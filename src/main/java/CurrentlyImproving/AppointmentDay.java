/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CurrentlyImproving;

import java.time.LocalDateTime;

import java.util.List;

/**
 *
 * @author ysr
 */
  public class AppointmentDay{
           LocalDateTime appointmentDate = null;
        boolean isAppointmentSelectedByManager;
        List<AppointmentNode> availableAppoinmentHoursInADay;
        
        
        public AppointmentDay(LocalDateTime appointmentDate) {
            this.appointmentDate = appointmentDate;
            isAppointmentSelectedByManager = true;
        }
        
        public void dayHoursConfiguraiton(String specificConfiguration, int appoinmentDuration){
            AppointmentHoursConfigurations thisDay=new AppointmentHoursConfigurations(this);
           
              availableAppoinmentHoursInADay=thisDay.generateAppointmentSlots(specificConfiguration, appoinmentDuration);
           
        }
        
        
   }