package CurrentlyImproving;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppointmentHoursConfigurations {

    public static final String START_HOUR_DEFAULT = "09:00";
    public static final String END_HOUR_DEFAULT = "17:00";
    public static final int DEFAULT_APPOINTMENT_DURATION = 30;

    private AppointmentDay appointmentDayInHandling;
    private List<AppointmentNode> appointmentSlots;
    private int startingHour;
    private int startingMinute;
    private int endingHour;
    private int endingMinute;

    public AppointmentHoursConfigurations(AppointmentDay appointmentDay) {
        this.appointmentDayInHandling = appointmentDay;
        this.appointmentSlots = new ArrayList<>();
    }

    public List<AppointmentNode> generateAppointmentSlots(String timeRange, int appointmentDuration) {
        int totalSlots;
        if (timeRange.isBlank()) {
            useDefaultTimes();
            totalSlots = calculateTotalSlots(appointmentDuration);
            createAppointmentNodes(totalSlots, appointmentDuration);
            return appointmentSlots;
        } else {
            parseTimeInput(timeRange);
            totalSlots = calculateTotalSlots(appointmentDuration);
            createAppointmentNodes(totalSlots, appointmentDuration);
            return appointmentSlots;
        }
    }

    private void parseTimeInput(String input) {
        try {
            String[] timeParts = input.split("-");
            if (timeParts.length != 2) {
                throw new IllegalArgumentException("Invalid time format. Use HH:mm-HH:mm");
            }

            String[] startComponents = timeParts[0].trim().split(":");
            String[] endComponents = timeParts[1].trim().split(":");

            startingHour = Integer.parseInt(startComponents[0]);
            startingMinute = Integer.parseInt(startComponents[1]);
            endingHour = Integer.parseInt(endComponents[0]);
            endingMinute = Integer.parseInt(endComponents[1]);

            validateTimeInputs();
        } catch (Exception e) {
            // Fall back to default values if parsing fails
            useDefaultTimes();
        }
    }

    private void validateTimeInputs() {
        if (startingHour < 0 || startingHour > 23 || endingHour < 0 || endingHour > 23
                || startingMinute < 0 || startingMinute > 59 || endingMinute < 0 || endingMinute > 59) {
            throw new IllegalArgumentException("Invalid time values");
        }

        LocalTime startTime = LocalTime.of(startingHour, startingMinute);
        LocalTime endTime = LocalTime.of(endingHour, endingMinute);

        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time cannot be before start time");
        }
    }

    private void useDefaultTimes() {
        LocalTime defaultStart = LocalTime.parse(START_HOUR_DEFAULT);
        LocalTime defaultEnd = LocalTime.parse(END_HOUR_DEFAULT);

        startingHour = defaultStart.getHour();
        startingMinute = defaultStart.getMinute();
        endingHour = defaultEnd.getHour();
        endingMinute = defaultEnd.getMinute();
    }

    private int calculateTotalSlots(int appointmentDuration) {
        int totalMinutes = (endingHour - startingHour) * 60 + (endingMinute - startingMinute);
        return totalMinutes / appointmentDuration;
    }

    private void createAppointmentNodes(int totalSlots, int appointmentDuration) {
        LocalTime currentTime = LocalTime.of(startingHour, startingMinute);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        for (int i = 0; i < totalSlots; i++) {
            LocalTime slotEndTime = currentTime.plusMinutes(appointmentDuration);

            AppointmentNode node = new AppointmentNode(
                    currentTime.format(formatter),
                    slotEndTime.format(formatter)
            );

            appointmentSlots.add(node);
            currentTime = slotEndTime;
        }
    }

}
