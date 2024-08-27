package service;

import dto.Bookings;
import dto.Doctor;
import dto.Slots;
import enums.Speciality;
import javafx.util.Pair;
import repository.InMemoryRepository;

import java.util.*;
import java.util.stream.Collectors;

public class DoctorService {

    public void  regDoctor(Doctor doctor){
        InMemoryRepository.getDoctorMap().put(doctor.getName(),doctor);
        System.out.println("Welcome Dr."+doctor.getName()+"!!");
    }

    public void markDocAvail(String name,List<Slots> slots){
    int flag=0;
        for (Slots slot:slots) {
            if (!isValidTimeSlot(slot)) {
                System.out.println("Sorry Dr. Curious slots are 30 mins only");
            }else {
                InMemoryRepository.getDoctorMap().get(name).getTimeSlots().add(slot);
                flag=1;
            }
        }
        if (flag==1)
        System.out.println("Done Doc!");
    }

    private boolean isValidTimeSlot(Slots slots) {

        String [] startTime=slots.getStartTime().split(":");
        String [] endTime=slots.getEndTime().split(":");

       int diffMin=(Integer.valueOf(endTime[0])-Integer.valueOf(startTime[0])) *60+
               Integer.valueOf(endTime[1])-Integer.valueOf(startTime[1]);
       if (diffMin==30)
            return true;

        return false;

    }

    public void showAvailByspeciality(Speciality speciality){
        List<Doctor> doctorsList=   InMemoryRepository.getDoctorMap().values().stream() // Stream over the values (doctors) directly
                .filter(doctor -> doctor.getSpeciality().equals(speciality)) // Filter by speciality
                .sorted(Comparator.comparing(doctor ->
                        doctor.getTimeSlots().stream()
                                .min(Comparator.comparing(Slots::getStartTime)) // Find the earliest start time slot
                                .map(Slots::getStartTime) // Get the start time of the earliest slot
                                .orElse("9999-12-31T23:59:59") // Use a high default value if no slots exist
                ))
                .collect(Collectors.toList()); // Collect the sorted list of doctors

       PriorityQueue<Pair<String,String>> priorityQueue=new PriorityQueue<Pair<String,String>>(Comparator.comparing(Pair::getValue));

        for (Doctor doctor:doctorsList) {
            for (Slots slot:doctor.getTimeSlots()) {
                priorityQueue.add(new Pair<>(doctor.getName(),slot.getStartTime()+" - "+slot.getEndTime()));
            }
        }
       while (!priorityQueue.isEmpty())
           System.out.println(priorityQueue.peek().getKey()+" : "+priorityQueue.poll().getValue());
    }

    public List<Bookings> getBookingForDoctor(String doctorId){
        return InMemoryRepository.getDoctorMap().get(doctorId).getBookings();
    }



    public Doctor trendingDoctor(){
      return InMemoryRepository.getDoctorMap().entrySet().stream()
              .sorted(Comparator.comparing(entry->entry.getValue().getBookings().size(), Collections.reverseOrder()))
              .map(Map.Entry::getValue)
              .findFirst()
              .orElse(null);
    }

}
