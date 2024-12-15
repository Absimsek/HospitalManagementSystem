/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CurrentlyImproving;

<<<<<<< HEAD
import java.time.LocalDateTime;


    // Inner class for appointment slots
=======

import java.time.LocalDateTime;


/**
 *
 * @author ysr
 */
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
    public  class AppointmentNode {
        private String startTime;
        private String endTime;
        private boolean isBooked;
<<<<<<< HEAD
        private String patientName; // Optional: for booking information
=======
        private Patient patient; 
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303

        public AppointmentNode(String startTime, String endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.isBooked = false;
<<<<<<< HEAD
            this.patientName = null;
=======
            this.patient = null;
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
        }

        // Getters
        public String getStartTime() { return startTime; }
        public String getEndTime() { return endTime; }
        public boolean isBooked() { return isBooked; }
<<<<<<< HEAD
        public String getPatientName() { return patientName; }

        public void bookAppointment(String patientName) {
            this.isBooked = true;
            this.patientName = patientName;
=======
        public Patient getPatientName() { return patient;
    }


        public void bookAppointment(Patient patient) {
            this.isBooked = true;
            this.patient = patient;
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
        }

        public void cancelAppointment() {
            this.isBooked = false;
<<<<<<< HEAD
            this.patientName = null;
=======
            this.patient = null;
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
        }

        @Override
        public String toString() {
            return String.format("%s-%s %s", 
                startTime, 
                endTime, 
<<<<<<< HEAD
                isBooked ? "(Booked by " + patientName + ")" : "(Available)");
=======
                isBooked ? "(Booked by " + patient + ")" : "(Available)");
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
        }
    }
    