/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AppoinmentManagementSystem;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ysr
 */
public class AppoinementTemprarryMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        Scanner input = new Scanner(System.in);

//        AppointmentManager myapman = new AppointmentManager();
//        // myapman.appoinmentManagerSide();
//        // myapman.appointmentApplicantSide();
//        // myapman.showOnlyApplicantSelected();
//        myapman.show();
//        
//        
        /**
         * Creation of sample oobject of doctor And Creation of Appoinment
         * Manager in order to acces manipulations
         */
        Doctor mydoc = new Doctor("yasir", "18", "2018.25.21", "nefroloji");
        AppoinmentManager buyrunNasılYardımcıOlam = new AppoinmentManager();

        /**
         * Accessing Doctor AppoinmentList And for Manipulation of Just Days we
         * call set function and send it result of buyrunNasılYardımcıOlam class
         * doctorSelectAppointments function as parameter we send is already
         * created appoinment list side of doctor
         */
        mydoc.setAppointmentDays(buyrunNasılYardımcıOlam.doctorSelectAppointments(mydoc.getAppointmentDays()));

        /**
         * Doctor set day specifications at once for all days
         */
//        //just keeping referance for each day
//        List<AppointmentDay> doctorDay=mydoc.getDoctorsAppoinmentDays();
//        
//           // Prompt for time range
//            System.out.println("Enter time range (HH:mm-HH:mm, or press Enter for default 09:00-17:00):");
//            String timeRange = input.nextLine();
//
//            // Prompt for appointment duration
//            System.out.println("Enter appointment duration in minutes (default is 30):");
//            String durationInput = input.nextLine();
//            
//            //Prompt for Break Times
//            System.out.println("Enter Break time starting(in each case duration 60 min. input:12, 13):");
//            String breakTime= input.nextLine();
//            
//            mydoc.setDoctorsAppoinmentDays(buyrunNasılYardımcıOlam.configureAppointmentHours(doctorDay, timeRange, durationInput, breakTime));
//            
        /**
         * Doctor set day hours for each day that his selected
         */
//          List<AppointmentDay> doctorDay=mydoc.getDoctorsAppoinmentDays();
//         
//          for (AppointmentDay day : doctorDay) {
//              System.out.println("Enter time range (HH:mm-HH:mm, or press Enter for default 09:00-17:00):");
//            String timeRange = input.nextLine();
//
//            // Prompt for appointment duration
//            System.out.println("Enter appointment duration in minutes (default is 30):");
//            String durationInput = input.nextLine();
//            
//            //Prompt for Break Times
//            System.out.println("Enter Break time starting(in each case duration 60 min. input:12, 13):");
//            String breakTime= input.nextLine();
//            
//            day=buyrunNasılYardımcıOlam.configureAppointmentHours(day, timeRange, timeRange, breakTime);
//        
//         }
//        
      /**
             * In here it ask doctor for specific day and that day give ability of cancel some interval appoinments
             */
            System.out.println("selection of already decleared appoinments for some configurations");
            buyrunNasılYardımcıOlam.showDays(mydoc.getAppointmentDays());
            System.out.println("\nSelect the day that you want to cancel appoinments");
            int nextInt = input.nextInt();input.nextLine();
            buyrunNasılYardımcıOlam.showAppoinmentsHoursForSpecifiedDay(nextInt, mydoc.getAppointmentDays());
            System.out.println(mydoc.getAppointmentDays().get(nextInt-1).getAppointmentDate()+"Do you want to configure again?(yes=1/no=0)");
            int selection=input.nextInt(); input.nextLine();
            if (selection==1) {
                System.out.println("You're configuring the date "+mydoc.getAppointmentDays().get(nextInt-1).getAppointmentDate() );
                buyrunNasılYardımcıOlam.showAppoinmentsHoursForSpecifiedDay(nextInt, mydoc.getAppointmentDays());
                System.out.println("Give me the time interval that you want to cancel(like: 14.00-16.00):");
                String interval=input.nextLine();
                List<AppointmentDay> doctorDays=mydoc.getAppointmentDays();
                List<AppointmentNode> changedNodes=buyrunNasılYardımcıOlam.appointmentSlotDestroyer(interval, mydoc.getAppointmentDays().get(nextInt-1).getAvailableAppointmentHoursInADay());
                AppointmentDay newDay=doctorDays.get(nextInt-1);
                newDay.setAvailableAppoinmentHoursInADay(changedNodes);
                doctorDays.set(nextInt-1, newDay);
                mydoc.setAppointmentDays(doctorDays);
                buyrunNasılYardımcıOlam.showAppoinmentsHoursForSpecifiedDay(nextInt, doctorDays);
                
            }else if(selection==0){
                System.out.println("nothing changed as you wish");
            }else System.out.println("invalid input");
            
            
            
        /**
         * In here it shows already created appoinments if doctor want to change
         * specific day information gives that ability
         */
//             System.out.println("selection of already decleared appoinments for some configurations");
//            buyrunNasılYardımcıOlam.showDays(mydoc.getDoctorsAppoinmentDays());
//            System.out.println("\nSelect the day that you want to configure");
//            int nextInt = input.nextInt();input.nextLine();
//            buyrunNasılYardımcıOlam.showAppoinmentsHoursForSpecifiedDay(nextInt, mydoc.getDoctorsAppoinmentDays());
//            System.out.println("Do you want to configure again?(yes=1/no=0)");
//            int selection=input.nextInt();
//            if (selection==1) {
//                System.out.println("You're configuring the date "+mydoc.getDoctorsAppoinmentDays().get(nextInt).getAppointmentDate() );
//                     System.out.println("Enter time range (HH:mm-HH:mm, or press Enter for default 09:00-17:00):");
//            String timeRange = input.nextLine();
//
//            // Prompt for appointment duration
//            System.out.println("Enter appointment duration in minutes (default is 30):");
//            String durationInput = input.nextLine();
//            
//            //Prompt for Break Times
//            System.out.println("Enter Break time starting(in each case duration 60 min. input:12, 13):");
//            String breakTime= input.nextLine();
//            buyrunNasılYardımcıOlam.configureAppointmentHours(mydoc.getDoctorsAppoinmentDays().get(nextInt), timeRange, durationInput, breakTime);
//            }else if(selection==0){
//                System.out.println("nothing changed as you wish");
//            }else System.out.println("invalid input");
//            
    }

}
