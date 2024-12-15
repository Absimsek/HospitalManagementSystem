/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CurrentlyImproving;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppoinmentManager {
<<<<<<< HEAD
=======

>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
    private AppointmentDayPlanner dayPlanner;
    private List<AppointmentDay> selectedDaysFromDoctor;
    private Scanner input;

    public AppoinmentManager() {
        this.input = new Scanner(System.in);
        this.dayPlanner = new AppointmentDayPlanner();
        this.selectedDaysFromDoctor = new ArrayList<>();
    }

<<<<<<< HEAD
    public void doctorSelectAppointments() {
        // Step 1: Select days using existing day planner
        selectedDaysFromDoctor = dayPlanner.planAppointmentDays();

        // Step 2: Configure hours for each selected day
        configureAppointmentHours();
    }

    private void configureAppointmentHours() {
        for (AppointmentDay day : selectedDaysFromDoctor) {
            // Display the date being configured
            System.out.println("Configuring appointments for: " + 
                day.appointmentDate.toLocalDate().format(DateTimeFormatter.ISO_DATE));

            // Prompt for time range
            System.out.println("Enter time range (HH:mm-HH:mm, or press Enter for default 09:00-17:00):");
            String timeRange = input.nextLine();

            // Prompt for appointment duration
            System.out.println("Enter appointment duration in minutes (default is 30):");
            String durationInput = input.nextLine();
            
            // Determine appointment duration
            int appointmentDuration = durationInput.isEmpty() ? 
                AppointmentHoursConfigurations.DEFAULT_APPOINTMENT_DURATION : 
                Integer.parseInt(durationInput);

            // Use the method in AppointmentDay to configure hours
            day.dayHoursConfiguraiton(timeRange, appointmentDuration);
        }
    }

    // Method to display configured appointments
    public void showAppointments() {
        if (selectedDaysFromDoctor.isEmpty()) {
            System.out.println("No appointments have been configured.");
            return;
        }

        System.out.println("Configured Appointments:");
        for (AppointmentDay day : selectedDaysFromDoctor) {
            System.out.println("\nDate: " + 
                day.appointmentDate.toLocalDate().format(DateTimeFormatter.ISO_DATE));
            
            if (day.availableAppoinmentHoursInADay != null && !day.availableAppoinmentHoursInADay.isEmpty()) {
                System.out.println("Available Time Slots:");
                for (AppointmentNode slot : day.availableAppoinmentHoursInADay) {
                    System.out.println(slot.getStartTime() + " - " + slot.getEndTime());
                }
            } else {
                System.out.println("No time slots configured for this day.");
            }
        }
    }
    
    
     public void showDays() {
        if (selectedDaysFromDoctor.isEmpty()) {
            System.out.println("No days have been selected.");
            return;
        }

        System.out.println("Selected Appointment Days:");
        for (int i = 0; i < selectedDaysFromDoctor.size(); i++) {
            AppointmentDay day = selectedDaysFromDoctor.get(i);
            System.out.println((i + 1) + ". " + 
                day.appointmentDate.toLocalDate().format(DateTimeFormatter.ISO_DATE));
        }
    }

    /**
     * Shows hours for a specified day
     * @param dayIndex The index of the day (1-based)
     * NOTE:Call ShowDays Function before calling that
     */
    public void showHoursForDay(int dayIndex) {
        // Validate day index
        if (selectedDaysFromDoctor.isEmpty()) {
            System.out.println("No days have been selected.");
            return;
        }

        // Adjust for 1-based indexing
        if (dayIndex < 1 || dayIndex > selectedDaysFromDoctor.size()) {
            System.out.println("Invalid day selection. Please choose a day between 1 and " + 
                selectedDaysFromDoctor.size());
            return;
        }
        

        // Get the selected day (subtract 1 for 0-based array indexing)
        AppointmentDay selectedDay = selectedDaysFromDoctor.get(dayIndex - 1);

        // Check if hours are configured
        if (selectedDay.availableAppoinmentHoursInADay == null || 
            selectedDay.availableAppoinmentHoursInADay.isEmpty()) {
            System.out.println("No hours configured for " + 
                selectedDay.appointmentDate.toLocalDate().format(DateTimeFormatter.ISO_DATE));
            return;
        }

        // Display hours for the selected day
        System.out.println("Available Hours for " + 
            selectedDay.appointmentDate.toLocalDate().format(DateTimeFormatter.ISO_DATE) + ":");
        
        for (int i = 0; i < selectedDay.availableAppoinmentHoursInADay.size(); i++) {
            AppointmentNode slot = selectedDay.availableAppoinmentHoursInADay.get(i);
            System.out.println((i + 1) + ". " + 
                slot.getStartTime() + " - " + slot.getEndTime());
        }
    }

    /**
     * Overloaded method to show hours with date instead of index
     * @param date The date to show hours for
     */
    public void showHoursForDay(LocalDate date) {
        // Find the matching day
        for (int i = 0; i < selectedDaysFromDoctor.size(); i++) {
            AppointmentDay day = selectedDaysFromDoctor.get(i);
            if (day.appointmentDate.toLocalDate().equals(date)) {
                showHoursForDay(i + 1);
                return;
            }
        }

        // If no matching day found
        System.out.println("No appointment day found for " + 
            date.format(DateTimeFormatter.ISO_DATE));
    }
}
    
=======
    /**
     * It help us to create day Nodes that will includes appoinments hours
     * We can think as doctor work day schedular
     * @param selectedDaysFromDoctor it takes input from Doctor class and it's own my appoinments list
     * @return returns back to original list which taken as parameter
     */
    public  List<AppointmentDay> doctorSelectAppointments(List<AppointmentDay> selectedDaysFromDoctor) {
        // Select days using existing day planner
        return  dayPlanner.planAppointmentDays(selectedDaysFromDoctor);
    }
    
    /**
    *Configuraitons for every planned day
    * @param selectedDaysFromDoctor are those days that user want to set hours
    * @param timeRange is the time interval that doctor will be working 
    * @param appoinmentDuration is appoinment length
    * @param breakTime is the time range when doctor unavailable for appoinments
    */
     public void configureAppointmentHours(List<AppointmentDay> selectedDaysFromDoctor, String timeRange, String appoinmentDuration, String breakTime) {
         for (AppointmentDay day : selectedDaysFromDoctor) {
              day.setAvailableAppoinmentHoursInADay(AppointmentHoursConfigurations.generateAppointmentSlots(timeRange, appoinmentDuration, breakTime));
         }
    }

    /**
    *Configuraitons for one day
    * @param day is the Day that user want to set hours
    * @param timeRange is the time interval that doctor will be working 
    * @param appoinmentDuration is appoinment length
    * @param breakTime is the time range when doctor unavailable for appoinments
    */
    public void configureAppointmentHours(AppointmentDay day, String timeRange, String appoinmentDuration, String breakTime) {
        day.setAvailableAppoinmentHoursInADay(AppointmentHoursConfigurations.generateAppointmentSlots(timeRange, appoinmentDuration, breakTime));
    }
    
    /**
     * Shows that choosen days from doctor
     * @param selectedDaysFromDoctor 
     */
    public void showDays( List<AppointmentDay> selectedDaysFromDoctor) {
        AppoinmentShow.showDays(selectedDaysFromDoctor);
    }
    /**
     * That shows all days and hours
     * @param selectedDaysFromDoctor 
     */
    public void showDaysAndHours( List<AppointmentDay> selectedDaysFromDoctor) {
        AppoinmentShow.showAppointments(selectedDaysFromDoctor);
    }
    /**
     * that shows specific days hours information   
     * @param dayIndex takes day index as input that is not very usufel since user can cross limit of array
     * @param selectedDaysFromDoctor takes days to specify wanted day
     */
    public void showAppoinmentsHoursForSpecifiedDay(int dayIndex, List<AppointmentDay> selectedDaysFromDoctor) {
        AppoinmentShow.showHoursForDay(dayIndex, selectedDaysFromDoctor);
    }
    /**
     * that shows specific day
     * @param specifiedDAte takes as input local date time specified date
     * @param selectedDaysFromDoctor 
     */
    public void showAppoinmentsHoursForSpecifiedDay(LocalDate specifiedDAte, List<AppointmentDay> selectedDaysFromDoctor) {
        AppoinmentShow.showHoursForDay(specifiedDAte, selectedDaysFromDoctor);
    }




//    public void configureAppointmentHours() {
//        for (AppointmentDay day : selectedDaysFromDoctor) {
//            // Display the date being configured
//            System.out.println("Configuring appointments for: " + 
//                day.getAppointmentDate().toLocalDate().format(DateTimeFormatter.ISO_DATE));
//
//            // Prompt for time range
//            System.out.println("Enter time range (HH:mm-HH:mm, or press Enter for default 09:00-17:00):");
//            String timeRange = input.nextLine();
//
//            // Prompt for appointment duration
//            System.out.println("Enter appointment duration in minutes (default is 30):");
//            String durationInput = input.nextLine();
//            
//            //Prompt for Break Times
//            System.out.println("Enter Break time range:");
//            String breakTime= input.nextLine();
//            // Determine appointment duration
//            int appointmentDuration = durationInput.isEmpty() ? 
//                AppointmentHoursConfigurations.DEFAULT_APPOINTMENT_DURATION : 
//                Integer.parseInt(durationInput);
//            
//            
//            // Use the method in AppointmentDay to configure hours
//            day.setAvailableAppoinmentHoursInADay(AppointmentHoursConfigurations.generateAppointmentSlots(timeRange, appointmentDuration, breakTime));
//            
//        }
//    }
}
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
