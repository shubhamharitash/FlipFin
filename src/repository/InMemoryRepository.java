package repository;

import dto.Bookings;
import dto.Doctor;
import dto.Patient;
import dto.Slots;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository {
    public static Map<String, Doctor> doctorMap;
    public static Map<String, Patient> patientMap;
    public static Map<String, Bookings> bookingsMap;

    public InMemoryRepository() {
        doctorMap=new ConcurrentHashMap<>();
        patientMap=new ConcurrentHashMap<>();
        bookingsMap=new ConcurrentHashMap<>();

    }
    public static Map<String, Doctor> getDoctorMap() {
        return doctorMap;
    }

    public static Map<String, Patient> getPatientMap() {
        return patientMap;
    }

    public static Map<String, Bookings> getBookingsMap() {
        return bookingsMap;
    }

}
