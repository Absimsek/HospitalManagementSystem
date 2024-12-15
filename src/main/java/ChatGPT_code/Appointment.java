package ChatGPT_code;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
class Appointment {
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;

    public Appointment(LocalDate date, LocalTime time, Doctor doctor, Patient patient) {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }

    @Override
    public String toString() {
        return "Appointment[Date: " + date + ", Time: " + time + ", Doctor: " + doctor.getName()
                + ", Patient: " + patient.getName() + "]";
    }
}