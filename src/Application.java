import dto.Doctor;
import dto.Patient;
import dto.Slots;
import enums.Speciality;
import repository.InMemoryRepository;
import service.BookingService;
import service.DoctorService;
import service.PatientService;
import service.SlotsService;

import java.io.FileNotFoundException;
import java.util.Arrays;


public class Application {
    public static void main(String[] args) throws FileNotFoundException {


        InMemoryRepository inMemoryRepository =new InMemoryRepository();

        BookingService bookingService=new BookingService();
        DoctorService doctorService=new DoctorService();
        PatientService patientService=new PatientService();
        SlotsService slotsService=new SlotsService();

            try {
                Doctor doctor=new Doctor("Curious", Speciality.Cardiologist);
                Doctor doctor1=new Doctor("Dreadful", Speciality.Dermatologist);
                Doctor doctor2=new Doctor("Daring", Speciality.Dermatologist);
                doctorService.regDoctor(doctor);
                doctorService.regDoctor(doctor1);
                doctorService.regDoctor(doctor2);


                doctorService.markDocAvail("Curious", Arrays.asList(new Slots("09:30","10:00"),new Slots("12:30","13:00"),new Slots("16:00","16:30")));

                doctorService.markDocAvail("Dreadful", Arrays.asList(new Slots("09:30","10:00"),new Slots("12:30","13:00"),new Slots("16:00","16:30")));

                doctorService.markDocAvail("Daring", Arrays.asList(new Slots("11:30","12:00"),new Slots("14:00","14:30")));


                patientService.regPatient(new Patient("PatientA"));

                patientService.regPatient(new Patient("PatientB"));
                patientService.regPatient(new Patient("PatientC"));

               doctorService.showAvailByspeciality(Speciality.Cardiologist);


                String bookingId1=bookingService.bookAppointment("PatientA", "Curious", "12:30");



                doctorService.showAvailByspeciality(Speciality.Cardiologist);

                doctorService.getBookingForDoctor("Curious").forEach(
                        doctorBookings -> System.out.println(doctorBookings.toString())
                );
                bookingService.checkPatientsAppointments("PatientA").forEach(
                        patientBooking-> System.out.println(patientBooking.toString())
                );
                bookingService.cancelDoctorsBooking(bookingId1);

                doctorService.showAvailByspeciality(Speciality.Dermatologist);
                String bookingId2=bookingService.bookAppointment("PatientB", "Curious", "12:30");

                String bookingId3 =bookingService.bookAppointment("PatientC", "Curious", "12:30");


                //WaitingList
                bookingService.cancelDoctorsBooking(bookingId2);

                System.out.println("Trending Doctor: "+doctorService.trendingDoctor());


            }
            catch (RuntimeException e){
                System.out.println(e);
            }

    }
}
