package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Patient {
    String name;
    List<Bookings> bookings;

    public Patient(String name) {
        this.name = name;
        bookings=new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bookings> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", bookings=" + bookings +
                '}';
    }

    public void setBookings(List<Bookings> bookings) {
        this.bookings = bookings;
    }
}
