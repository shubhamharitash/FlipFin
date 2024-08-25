package dto;

import enums.Speciality;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    String name;
    List<Slots> timeSlots;
    Speciality speciality;
    List<Bookings> bookings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", timeSlots=" + timeSlots +
                ", speciality=" + speciality +
                ", bookings=" + bookings +
                '}';
    }

    public List<Slots> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<Slots> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Bookings> getBookings() {
        return bookings;
    }

    public void setBookings(List<Bookings> bookings) {
        this.bookings = bookings;
    }


    public Doctor(String name, Speciality speciality) {
        this.name = name;
        timeSlots=new ArrayList<>();
        this.speciality = speciality;
        bookings =new ArrayList<>();
    }
}
