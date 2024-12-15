/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppoinmentManagementSystem;


import java.time.LocalDateTime;
import queuebasedappointmentsystem.Patient;

/**
 *
 * @author ysr
 */
    public  class AppointmentNode {
        private String startTime;
        private String endTime;
        private boolean isBooked;
        private Patient patient; 

        public AppointmentNode(String startTime, String endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.isBooked = false;
            this.patient = null;
        }

        // Getters
        public String getStartTime() { return startTime; }
        public String getEndTime() { return endTime; }
        public boolean isBooked() { return isBooked; }
        public Patient getPatientName() { return patient;
    }


        public void bookAppointment(Patient patient) {
            this.isBooked = true;
            this.patient = patient;
        }

        public void cancelAppointment() {
            this.isBooked = false;
            this.patient = null;
        }

        @Override
        public String toString() {
            return String.format("%s-%s %s", 
                startTime, 
                endTime, 
                isBooked ? "(Booked by " + patient + ")" : "(Available)");
        }
    }
    