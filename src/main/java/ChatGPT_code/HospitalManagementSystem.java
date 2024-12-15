package ChatGPT_code;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class HospitalManagementSystem {
    private Map<Doctor, List<Appointment>> doctorAppointments;  // Doctor -> List of Appointments
    private TreeMap<LocalDate, List<Appointment>> dateAppointments; // Date -> List of Appointments

    public HospitalManagementSystem() {
        doctorAppointments = new HashMap<>();
        dateAppointments = new TreeMap<>();
    }

    // Schedule an Appointment
    public void scheduleAppointment(Doctor doctor, Patient patient, LocalDate date, LocalTime time) {
        Appointment newAppointment = new Appointment(date, time, doctor, patient);

        // Add to doctor-specific schedule
        doctorAppointments.putIfAbsent(doctor, new ArrayList<>());
        doctorAppointments.get(doctor).add(newAppointment);

        // Add to date-specific schedule
        dateAppointments.putIfAbsent(date, new ArrayList<>());
        dateAppointments.get(date).add(newAppointment);

        System.out.println("Appointment scheduled successfully:\n" + newAppointment);
    }

    // Get Doctor's Appointments
    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
        return doctorAppointments.getOrDefault(doctor, new ArrayList<>());
    }

    // Get Appointments on a Specific Date
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return dateAppointments.getOrDefault(date, new ArrayList<>());
    }
    public static void main(String[] args) {
        HospitalManagementSystem hospital = new HospitalManagementSystem();

        // Create doctors
        Doctor doctor1 = new Doctor("D001", "Dr. Smith", "Cardiologist");
        Doctor doctor2 = new Doctor("D002", "Dr. Johnson", "Neurologist");

        // Create patients
        Patient patient1 = new Patient("P001", "John Doe", "High blood pressure");
        Patient patient2 = new Patient("P002", "Jane Roe", "Migraines");

        // Schedule appointments
        hospital.scheduleAppointment(doctor1, patient1, LocalDate.of(2024, 6, 15), LocalTime.of(10, 0));
        hospital.scheduleAppointment(doctor1, patient2, LocalDate.of(2024, 6, 15), LocalTime.of(11, 0));
        hospital.scheduleAppointment(doctor2, patient1, LocalDate.of(2024, 6, 16), LocalTime.of(9, 30));

        // Retrieve appointments
        System.out.println("\nAppointments for " + doctor1.getName() + ":");
        for (Appointment a : hospital.getAppointmentsByDoctor(doctor1)) {
            System.out.println(a);
        }

        System.out.println("\nAppointments on 2024-06-15:");
        for (Appointment a : hospital.getAppointmentsByDate(LocalDate.of(2024, 6, 15))) {
            System.out.println(a);
        }
    }
}