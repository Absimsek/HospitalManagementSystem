package AppointmentManagement;

import java.util.*;

import java.time.LocalDateTime;

import java.time.Month;

import java.time.*;


public class Manager {



    Scanner input = new Scanner(System.in);



    String selectedAp;//Look for this inside of show appointment calender function

    Doctor doctor;



    ArrayList<LocalDateTime> dates = new ArrayList();

    Queue<AppointmentNode> myAppointments = new LinkedList();



    void appointmentCreator(int furtherDays, Queue<AppointmentNode> myAppointments) {

        //diyorum ki tarih objesi oluşturmadan tarih çıktısı verelim, sonrasında kullanıcının seçimine göre

        //localdatetime objesi oluşturalım böylece efficieny artsın. Ayrıca geriye dönük diyelim ki doktor dün bir kaç günü kendine ayarladı

        //yarın geldiğinde tekrar doktor randevu açmak istediğinde dün açtığı randevular onda gözüksün böylece kesişmeyi önleyelim



        LocalDateTime oneApnt;

        oneApnt = LocalDateTime.of(2024, Month.NOVEMBER, 24, 9, 0);

        for (int i = 0; i < furtherDays; i++) {



            for (int j = 0; j < 42; j++) {

                oneApnt = oneApnt.plusMinutes(10);

                if (oneApnt.getHour() == 12) {

                    oneApnt = oneApnt.plusHours(1);

                }



                dates.add(oneApnt);

            }

            oneApnt = LocalDateTime.of(2024, Month.NOVEMBER, (oneApnt.getDayOfMonth() + 1), 9, 0);



        }



        for (AppointmentNode myAppointment : myAppointments) {

            for (LocalDateTime date : dates) {

                if (myAppointment.appointmentDate.equals(date)) {

                    dates.remove(myAppointment.appointmentDate);

                    break; // Bir eşleşme bulduğumuzda diğer randevularla karşılaştırmayı bırak

                }



            }

        }



        for (LocalDateTime date : dates) {

            System.out.println(date);

        }

        System.out.println("For which time interval you're open to work?");

        selectedAp = input.nextLine();

        int[] arr = Arrays.stream(selectedAp.split(" ")).mapToInt(Integer::parseInt).toArray();



        for (int i : arr) {

            myAppointments.add(new AppointmentNode(dates.get(i)));

        }



        dates.removeAll(dates);



    }










    void showAppointment() {

        for (AppointmentNode myAppointment : myAppointments) {

            myAppointment.display();

        }

    }



    class AppointmentNode {



        Patient patient = null;

        Boolean doctorOpenTheNode;

        Boolean appointmentTaken = false;

        String noteToDoctor;



        LocalDateTime appointmentDate;



        public AppointmentNode(LocalDateTime appointmentDate) {

            this.appointmentDate = appointmentDate;

            this.doctorOpenTheNode = true;

        }



        public void display() {

            System.out.println(appointmentDate + " " + doctorOpenTheNode + " patient: " + appointmentTaken + " pat:" + patient);

        }



        void takeAppointment(Patient pat, String noteToDoctor) {

            if (appointmentTaken) {

                System.out.println("the appointment has already taken");

            } else {

                this.patient = pat;

                appointmentTaken = true;

                this.noteToDoctor = noteToDoctor;

            }


        }



        void cancelAppointment(Patient pat) {

            if (patient == pat) {

                patient = null;

                appointmentTaken = false;

                this.noteToDoctor = " ";

            } else if (patient != pat) {

                System.out.println("you cant cancel that appointment");

            }

        }



    }



}
