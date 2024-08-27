package service;

import dto.Bookings;
import dto.Doctor;
import enums.BookingType;
import repository.InMemoryRepository;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    public void cancelDoctorsBooking(String bookingId){
        Bookings bookings=InMemoryRepository.getBookingsMap().get(bookingId);
        InMemoryRepository.getDoctorMap().get(bookings.getDoctor()).getBookings().remove(bookings.getPatient());

        InMemoryRepository.getDoctorMap().get(bookings.getDoctor()).getTimeSlots().stream()
                .filter(slot -> slot.getStartTime().equals(bookings.getSlot()))
                .findFirst()
                .map(slot -> {
                    slot.setBooked(false);
                    return true;
                })
                .orElse(false);
        System.out.println("Booking Cancelled");
        allotBookingToWaitingList(bookings);

        InMemoryRepository.getPatientMap().get(bookings.getPatient()).getBookings().remove(bookingId);

    }

    private void allotBookingToWaitingList(Bookings booking) {

       Bookings waitingBooking= InMemoryRepository.getBookingsMap().entrySet().stream()
                .filter(entry -> entry.getValue().getBookingType().equals(BookingType.WAITING) &&
                        entry.getValue().getDoctor().equals(booking.getDoctor()))
                .sorted(Comparator.comparing(entry -> entry.getValue().getBookingTimeStamp()))
                .map(Map.Entry::getValue)
               .findFirst()
               .orElse(null);
    if (waitingBooking!=null)
        bookAppointment(waitingBooking.getPatient(),waitingBooking.getDoctor(), waitingBooking.getSlot());
    }

    public List<Bookings> checkPatientsAppointments(String patientId){
      return   InMemoryRepository.getPatientMap().get(patientId).getBookings().stream().collect(Collectors.toList());
    }

    public static String getBookingId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    public String bookAppointment(String patientName,String doctorName,String timeSlot) {

        if (checkIfPatientAlreadyHaveBookingForThisTime(patientName, timeSlot))
            return "You Already Have Booking For This Time";

        String bookingId = InMemoryRepository.getDoctorMap().get(doctorName).getTimeSlots().stream()
                .filter(slots -> slots.getStartTime().equals(timeSlot))
                .findFirst()
                .map(slots -> {
                    Bookings bookings;
                    if (!slots.isBooked()) {
                        slots.setBooked(true);
                        bookings = new Bookings(doctorName, patientName, timeSlot, new Date(), BookingType.CONFIRM);
                        InMemoryRepository.getPatientMap().get(patientName).getBookings().add(bookings);
                        InMemoryRepository.getDoctorMap().get(doctorName).getBookings().add(bookings);
                    } else {
                        bookings = new Bookings(doctorName, patientName, timeSlot, new Date(), BookingType.WAITING);
                    }
                    InMemoryRepository.getBookingsMap().put(bookings.getId(), bookings);
                    return bookings.getId();
                })
                .orElse(null);
        if (bookingId !=null)
            System.out.println(" Booked. Booking id: "+ bookingId);
    return bookingId;

}


    private boolean checkIfPatientAlreadyHaveBookingForThisTime(String patientName, String timeSlot) {
        return   InMemoryRepository.getPatientMap().get(patientName).getBookings().stream()
                .filter(bookings -> bookings.getSlot().equals(timeSlot))
                .findFirst()
                .orElse(null)!=null?true:false;
    }

}
