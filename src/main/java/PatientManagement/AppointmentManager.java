package PatientManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author ysr
 */
public class AppointmentManager {

    Scanner input = new Scanner(System.in);

    LinkedList<appointmentNode> avaliableAppointmentDates = new LinkedList();

    public AppointmentManager() {
        appointmentCreator();
    }

    public void appointmentCreator() {//This class decleare appoinments for further 15 days. While doing this it skip weekends and lunch breaks for per day
        LocalDateTime aptDate = LocalDateTime.now();
        aptDate = aptDate.of(LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(),
                9, 0).plusDays(1);
        int i = 0;//
        while (i < 15) {
            switch (aptDate.getDayOfWeek()) {
                case SATURDAY:
                    aptDate = aptDate.plusDays(2);
                    break;
                case SUNDAY:
                    aptDate = aptDate.plusDays(1);
                    break;
                default:
                    while (aptDate.getHour() <= 17) {
                        if (aptDate.getHour() == 12) {
                            aptDate = aptDate.plusHours(1);
                        }

                        avaliableAppointmentDates.add(new appointmentNode(aptDate));
                        aptDate = aptDate.plusMinutes(10);
                    }
                    aptDate = aptDate.of(
                            aptDate.getYear(),
                            aptDate.getMonth(),
                            aptDate.getDayOfMonth(),
                            9, 0).plusDays(1);
                    break;
            }
            i++;
        }

    }

    void show() {//Ability to show all appoinments that are avaliable
        int i = 0;
        for (appointmentNode avaliableAppointmentDate : avaliableAppointmentDates) {
            System.out.println(i + ". " + avaliableAppointmentDate.appointmentDate);
            i++;
        }
    }

    void appointmentSelection(appoinmentEnum accessLevel) {//each class will acces methods calling this function
        switch (accessLevel) {
            case DOCTOR:
                appoinmentDoctorSide();
                break;
            case PATIENT:
                appointmentPatientSide();
                break;
            default:
                throw new AssertionError();
        }
    }

    void appoinmentDoctorSide() {//this give ability of choice appropiate days for appoinment side of doctor
        show();
        System.out.println("Select the appointments you can apply");
        String mystring = input.nextLine();
        List<Integer> mychoices = parseRanges(mystring);
        for (Integer mychoice : mychoices) {
            avaliableAppointmentDates.get(mychoice).isAppointmentSelectedByDoctor = true;
        }

    }

    void appointmentPatientSide() {//patient side appoinment function that give ability of choice for appropiate day side of patient
        showOnlyDoctorApproved();
        System.out.println("Select the appointments you can apply");
        int myChoice = input.nextInt() + 1;

        avaliableAppointmentDates.get(myChoice).isAppointmentTakenByPatient = true;

    }

    void showOnlyDoctorApproved() {//that help us to show only doctor approved elemnts
        int i = 0;
        for (appointmentNode avaliableAppointmentDate : avaliableAppointmentDates) {
            if (avaliableAppointmentDate.isAppointmentSelectedByDoctor == true) {
                System.out.println(i + ". " + avaliableAppointmentDate.appointmentDate);
                i++;
            }
        }

    }

    void showOnlyPatientSelected() {// that helps us to show only choosen appoinment biside of patient. This will be help to doctor see which appoinments hi/she has
        for (appointmentNode avaliableAppointmentDate : avaliableAppointmentDates) {
            if (avaliableAppointmentDate.isAppointmentTakenByPatient == true) {
                System.out.println(avaliableAppointmentDate.appointmentDate);
            }
        }
    }

    public static List<Integer> parseRanges(String input) {//This function gives ability of choice range for the doctor like 1-30 from one to thirty
        List<Integer> numbers = new ArrayList<>();
        String[] ranges = input.split(" ");
        for (String range : ranges) {
            String[] bounds = range.split("-");
            int start = Integer.parseInt(bounds[0]);
            int end = Integer.parseInt(bounds[1]);
            for (int i = start; i <= end; i++) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    class appointmentNode {//basic appoinment node for arrange visibilty of dates

        LocalDateTime appointmentDate = null;
        boolean isAppointmentSelectedByDoctor;
        boolean isAppointmentTakenByPatient;
        
        
        public appointmentNode(LocalDateTime appointmentDate) {
            this.appointmentDate = appointmentDate;
        }

    }

}
