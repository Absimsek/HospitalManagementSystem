/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CurrentlyImproving;

import java.time.LocalDateTime;


    // Inner class for appointment slots
    public  class AppointmentNode {
        private String startTime;
        private String endTime;
        private boolean isBooked;
        private String patientName; // Optional: for booking information

        public AppointmentNode(String startTime, String endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.isBooked = false;
            this.patientName = null;
        }

        // Getters
        public String getStartTime() { return startTime; }
        public String getEndTime() { return endTime; }
        public boolean isBooked() { return isBooked; }
        public String getPatientName() { return patientName; }

        public void bookAppointment(String patientName) {
            this.isBooked = true;
            this.patientName = patientName;
        }

        public void cancelAppointment() {
            this.isBooked = false;
            this.patientName = null;
        }

        @Override
        public String toString() {
            return String.format("%s-%s %s", 
                startTime, 
                endTime, 
                isBooked ? "(Booked by " + patientName + ")" : "(Available)");
        }
    }
    