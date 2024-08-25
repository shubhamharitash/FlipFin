package service;

import dto.Bookings;
import dto.Patient;
import repository.InMemoryRepository;

import java.util.List;

public class PatientService {
    public void regPatient(Patient patient){
        InMemoryRepository.getPatientMap().put(patient.getName(),patient);
    }

}
