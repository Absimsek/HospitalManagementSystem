package AppointmentManagement;

public class AppointmentRunner {
    public static void main(String[] args) {
        Manager mymang = new Manager();

        mymang.appointmentCreator(1, mymang.myAppointments);
        // mymang.appointmentCalender();
        // mymang.showAppointmentCalender();
        mymang.appointmentCreator(1, mymang.myAppointments);
        mymang.showAppointment();


    }
}
