/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppoinmentManagementSystem;

import java.time.LocalDateTime;

import java.util.List;

/**
 *
 * @author ysr
 */
public class AppointmentDay {

    private LocalDateTime appointmentDate = null;
    private boolean isAppointmentSelectedByManager;
    private List<AppointmentNode> availableAppoinmentHoursInADay;

    public AppointmentDay(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
        isAppointmentSelectedByManager = true;
    }

    //Getters and Setters
    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate;}
    public boolean isAppointmentSelectedByManager() {  return isAppointmentSelectedByManager; }
    public void setIsAppointmentSelectedByManager(boolean isAppointmentSelectedByManager) {    this.isAppointmentSelectedByManager = isAppointmentSelectedByManager;  }
    public List<AppointmentNode> getAvailableAppoinmentHoursInADay() {   return availableAppoinmentHoursInADay;  }
    public void setAvailableAppoinmentHoursInADay(List<AppointmentNode> availableAppoinmentHoursInADay) {this.availableAppoinmentHoursInADay = availableAppoinmentHoursInADay;  }
    
     
}
