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

    public AppointmentDay(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
        isAppointmentSelectedByManager = true;
    }

    //Getters and Setters
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate;}
    public boolean isAppointmentSelectedByManager() {  return isAppointmentSelectedByManager; }
    public void setIsAppointmentSelectedByManager(boolean isAppointmentSelectedByManager) {    this.isAppointmentSelectedByManager = isAppointmentSelectedByManager;  }
    public List<AppointmentNode> getAvailableAppoinmentHoursInADay() {   return availableAppoinmentHoursInADay;  }
    public void setAvailableAppoinmentHoursInADay(List<AppointmentNode> availableAppoinmentHoursInADay) {this.availableAppoinmentHoursInADay = availableAppoinmentHoursInADay;  }
    
     
}
