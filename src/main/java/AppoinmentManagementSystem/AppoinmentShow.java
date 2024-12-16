/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppoinmentManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author ysr
 */
public class AppoinmentShow {
     /*
    * That shows all possible appoinments for each day
    *A.k.a every appoinment node that has been created
    */
    public static void showAppointments(List<AppointmentDay> selectedDaysFromDoctor) {
        if (selectedDaysFromDoctor.isEmpty()) {
            System.out.println("No appointments have been configured.");
            return;
        }

        System.out.println("Configured Appointments:");
        for (AppointmentDay day : selectedDaysFromDoctor) {
            System.out.println("\nDate: " + 
                day.getAppointmentDate());
            
            if (day.getAvailableAppointmentHoursInADay() != null && !day.getAvailableAppointmentHoursInADay().isEmpty()) {
                System.out.println("Available Time Slots:");
                for (AppointmentNode slot : day.getAvailableAppointmentHoursInADay()) {
                    System.out.println(slot.getStartTime() + " - " + slot.getEndTime());
                }
            } else {
                System.out.println("No time slots configured for this day.");
            }
        }
    }
    
    
    
     public static void showDays(List<AppointmentDay> selectedDaysFromDoctor) {
        if (selectedDaysFromDoctor.isEmpty()) {
            System.out.println("No days have been selected.");
            return;
        }

        System.out.println("Selected Appointment Days:");
        for (int i = 0; i < selectedDaysFromDoctor.size(); i++) {
            AppointmentDay day = selectedDaysFromDoctor.get(i);
            System.out.println((i + 1) + ". " + 
                day.getAppointmentDate());
        }
    }

     
     
    /**
     * Shows hours for a specified day
     * @param dayIndex The index of the day (1-based)
     * NOTE:Call ShowDays Function before calling that
     */
    public static void showHoursForDay(int dayIndex,List<AppointmentDay> selectedDaysFromDoctor) {
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
        if (selectedDay.getAvailableAppointmentHoursInADay() == null || 
            selectedDay.getAvailableAppointmentHoursInADay().isEmpty()) {
            System.out.println("No hours configured for " + 
                selectedDay.getAppointmentDate());
            return;
        }

        // Display hours for the selected day
        System.out.println("Available Hours for " + 
            selectedDay.getAppointmentDate() + ":");
        
        for (int i = 0; i < selectedDay.getAvailableAppointmentHoursInADay().size(); i++) {
            AppointmentNode slot = selectedDay.getAvailableAppointmentHoursInADay().get(i);
            System.out.println((i + 1) + ". " + 
                slot.getStartTime() + " - " + slot.getEndTime());
        }
    }

    /**
     * Overloaded method to show hours with date instead of index
     * @param date The date to show hours for
     */
    public static void showHoursForDay(LocalDate date,List<AppointmentDay> selectedDaysFromDoctor) {
        // Find the matching day
        for (int i = 0; i < selectedDaysFromDoctor.size(); i++) {
            AppointmentDay day = selectedDaysFromDoctor.get(i);
            if (day.getAppointmentDate().equals(date)) {
                showHoursForDay(i + 1,  selectedDaysFromDoctor);
                return;
            }
        }

        // If no matching day found
        System.out.println("No appointment day found for " + 
            date.format(DateTimeFormatter.ISO_DATE));
    }
}
