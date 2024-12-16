/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppoinmentManagementSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

/**
 *
 * @author ysr
 */
public class AppointmentDay {
    //Bu class'da gün için çalışma aralığı ve break time bilgisi tutulnmalı
    
    private LocalDate appointmentDate = null;
    private boolean isAppointmentSelectedByManager;
    private List<AppointmentNode> availableAppoinmentHoursInADay;
    private String breakTimeRange;
    private String workingTimeRange;

    public AppointmentDay(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
        isAppointmentSelectedByManager = true;
    }
    
    

    //Getters and Setters
    public String getBreakTimeRange() { return breakTimeRange; }
    public void setBreakTimeRange(String breakTimeRange) { this.breakTimeRange = breakTimeRange; }
    public String getWorkingTimeRange() { return workingTimeRange;}
    public void setWorkingTimeRange(String workingTimeRange) { this.workingTimeRange = workingTimeRange; }
    public LocalDate getAppointmentDate() {return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate;}
    public boolean isAppointmentSelectedByManager() {  return isAppointmentSelectedByManager; }
    public void setIsAppointmentSelectedByManager(boolean isAppointmentSelectedByManager) {    this.isAppointmentSelectedByManager = isAppointmentSelectedByManager;  }
    public List<AppointmentNode> getAvailableAppointmentHoursInADay() {   return availableAppoinmentHoursInADay;  }
    public void setAvailableAppoinmentHoursInADay(List<AppointmentNode> availableAppoinmentHoursInADay) {this.availableAppoinmentHoursInADay = availableAppoinmentHoursInADay;  }
    
     
}
