package dto;

import enums.BookingType;
import service.BookingService;

import java.util.Date;

public class Bookings {
    public String getId() {
        return id;
    }

    String id;
    String doctor;
    String patient;
    String slot;

    public Date getBookingTimeStamp() {
        return bookingTimeStamp;
    }

    public void setBookingTimeStamp(Date bookingTimeStamp) {
        this.bookingTimeStamp = bookingTimeStamp;
    }

    Date bookingTimeStamp;

    BookingType bookingType;
    public void setId(String id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlots(Slots slots) {
        this.slot = slot;
    }


    @Override
    public String toString() {
        return "Bookings{" +
                "id='" + id + '\'' +
                ", doctor='" + doctor + '\'' +
                ", patient='" + patient + '\'' +
                ", slot='" + slot + '\'' +
                ", bookingTimeStamp=" + bookingTimeStamp +
                ", bookingType=" + bookingType +
                '}';
    }

    public Bookings(String doctor, String patient, String slot, Date bookingTimeStamp, BookingType bookingType) {
        this.id= BookingService.getBookingId();
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
        this.bookingTimeStamp = bookingTimeStamp;
        this.bookingType = bookingType;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

}
