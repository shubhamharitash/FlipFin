# FlipFin
FlipFin/FlipMed


Context:
We are required to build an app that lets patients connect to doctors and book appointments.
The day is divided into time slots of 30 mins each, starting from 9 am to 9 pm. Doctors can login to the portal and declare their availability for the given day in terms of slots. Patients can login and book appointments/ cancel existing appointments. 
For simplicity you can assume that the doctors’ availability is declared for that particular day only. 

Requirements:
1. A new doctor should be able to register, and mention his/her speciality among (Cardiologist, Dermatologist, Orthopedic, General Physician)
2. A doctor should be able to declare his/her availability in each slot for the day. For example, the slots will be of 30 mins like 9am-9.30am, 9.30am-10am.
3. Patients should be able to login, and search available slots based on speciality.  
4. The slots should be displayed in a ranked fashion. Default ranking strategy should be to rank by start time. But we should be able to plugin more strategies like Doctor’s rating etc in future.
5. Patients should be able to book appointments with a doctor for an available slot.A patient can book multiple appointments in a day.  A patient cannot book two appointments with two different doctors in the same time slot.
6. Patients can also cancel an appointment, in which case that slot becomes available for someone else to book.
7 Build a waitlist feature:
 - If the patient wishes to book a slot for a particular doctor that is already booked, then add this patient to the waitlist. If the patient with whom the appointment is booked originally, cancels the appointment, then the first in the waitlist gets the appointment.
8. A patient/doctor should be able to view his/her booked appointments for the day.

Bonus:
9. Trending Doctor: Maintain at any point of time which doctor has the most appointments.
Examples:
The input/output need not be exactly in this format but the functionality should remain intact
i: input
o: output
i: registerDoc -> Curious-> Cardiologist
o: Welcome Dr. Curious !!
i: markDocAvail: Curious 9:30-10:30
o: Sorry Dr. Curious slots are 30 mins only
i: markDocAvail: Curious 9:30-10:00, 12:30-13:00, 16:00-16:30
o: Done Doc!
i: registerDoc -> Dreadful-> Dermatologist
o: Welcome Dr. Dreadful !!
i: markDocAvail: Dreadful 9:30-10:00, 12:30-13:00, 16:00-16:30
o: Done Doc!
i: showAvailByspeciality: Cardiologist
o: Dr.Curious: (9:30-10:00)
o: Dr.Curious: (12:30-13:00)
o: Dr.Curious: (16:00-16:30)
i:  bookAppointment: (PatientA, Dr.Curious, 12:30)
o: Booked. Booking id: 1234
i: showAvailByspeciality: Cardiologist
o: Dr.Curious: (9:30-10:00)
o: Dr.Curious: (16:00-16:30)
i: cancelBookingId: 1234
o: Booking Cancelled
i: showAvailByspeciality: Cardiologist
o: Dr.Curious: (9:30-10:00)
o: Dr.Curious: (12:30-13:00)
o: Dr.Curious: (16:00-16:30)
i: bookAppointment: (PatientB, Dr.Curious, 12:30)
o: Booked. Booking id: 5678
i: registerDoc -> Daring-> Dermatologist
o: Welcome Dr. Daring !!
i: markDocAvail: Daring 11:30-12:00 14:00-14:30
o: Done Doc!
i: showAvailByspeciality: Dermatologist
o: Dr.Dreadful: (9:30-10:00)
o: Dr.Daring: (11:30-12:00)
o: Dr.Dreadful: (12:30-13:00)
o: Dr.Daring:(14:00-14:30)
o: Dr.Dreadful: (16:00-16:30)
Guidelines:
1. Time: 90 mins
2. Please discuss the solution with an interviewer
3. Please do not access internet for anything EXCEPT syntax
4. You are free to use the language of your choice
5. All code should be your own
6. Please focus on the Bonus questions only after ensuring the required features are complete and demoable.
Expectations:
1. We are not expecting you to write REST API or create UI. It's just a functional APIs are expected here.
2. Create the sample data yourself. You can put it into a file, test case or main driver program itself.
3. Code should be demo-able. Either by using a main driver program or test cases.
4. Code should be modular. Code should have basic OO design. Please do not jam the responsibilities of one class into another.
5. Code should be extensible. Wherever applicable, use interfaces and contracts between different methods. It should be easy to add/remove functionality without re-writing the entire codebase.
6. Code should handle edge cases properly and fail gracefully.
7. Code should be legible, readable and DRY

