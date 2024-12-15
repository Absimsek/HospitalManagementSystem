/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppoinmentManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppoinmentManager {

    private AppointmentDayPlanner dayPlanner;
    private List<AppointmentDay> selectedDaysFromDoctor;
    private Scanner input;

    public AppoinmentManager() {
        this.input = new Scanner(System.in);
        this.dayPlanner = new AppointmentDayPlanner();
        this.selectedDaysFromDoctor = new ArrayList<>();
    }

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
    /**
     * 
     * @param interval
     * @param appointmentsList
     * @return 
     */
    public List<AppointmentNode> appointmentSlotDestroyer(String interval,List<AppointmentNode> appointmentsList){
        return AppointmentHoursConfigurations.deleteAppointmentsInInterval(interval, appointmentsList);
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
