package CurrentlyImproving;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppointmentHoursConfigurations {

<<<<<<< HEAD
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
=======
 
    public static final String START_HOUR_DEFAULT = "09:00";
    public static final String END_HOUR_DEFAULT = "17:00";
    public static final int DEFAULT_APPOINTMENT_DURATION = 30;
    public static final LocalTime DEFAULT_BREAK_START =LocalTime.of(12,00);
    public static final LocalTime DEFAULT_BREAK_END =LocalTime.of(13,00);
    private static AppointmentDay appointmentDayInHandling;
    private static List<AppointmentNode> appointmentSlots=new ArrayList<>();
    private static int startingHour;
    private static int startingMinute;
    private static int endingHour;
    private static int endingMinute;
    private static List<BreakTime> breakTimes= new ArrayList<>();

    public static void reset() {
        appointmentSlots.clear();
        breakTimes.clear();
    }
    
    private static int appoinmentDurationDecider(String appointmentDuration){
        return appointmentDuration.isEmpty()
                ? AppointmentHoursConfigurations.DEFAULT_APPOINTMENT_DURATION
                : Integer.parseInt(appointmentDuration);
    }
    public static List<AppointmentNode> generateAppointmentSlots(String timeRange, String appointmentDurationInput, String breakTime) {
//         Clear previous slots and breaks
       if (!appointmentSlots.isEmpty()) { appointmentSlots.clear(); }
       if (!breakTimes.isEmpty()) { breakTimes.clear(); }
          

        int appointmentDuration = appoinmentDurationDecider(appointmentDurationInput);

        // Parse break times if provided
        if (breakTime != null) {
           
                addBreakTime(breakTime);
            }
        

        // Generate slots with break times considered
        if (timeRange.isBlank()) {
            useDefaultTimes();
            return createAppointmentSlotsWithBreaks(appointmentDuration);
        } else {
            parseTimeInput(timeRange);
            return createAppointmentSlotsWithBreaks(appointmentDuration);
        }
    }

    private static void addBreakTime(String breakTimeStr) {
        try {
            String[] breakParts = breakTimeStr.split("-");
            if (breakParts.length != 2) {
                throw new IllegalArgumentException("Invalid break time format. Use HH.mm-HH.mm");
            }

            LocalTime breakStart = LocalTime.parse(breakParts[0].trim(),DateTimeFormatter.ofPattern("HH.mm"));
            LocalTime breakEnd = LocalTime.parse(breakParts[1].trim(),DateTimeFormatter.ofPattern("HH.mm"));

            breakTimes.add(new BreakTime(breakStart, breakEnd));
        } catch (Exception e) {
            // Log or handle parsing error as needed
            String exceptionMessage= breakTimeStr.isEmpty()? "null":breakTimeStr;
            System.err.println("Could not parse break time: " + exceptionMessage + 
                    "\n Default Break time will be applied");
            breakTimes.add(new BreakTime(DEFAULT_BREAK_START,DEFAULT_BREAK_END));
        }
    }

    private static List<AppointmentNode> createAppointmentSlotsWithBreaks(int appointmentDuration) {
        LocalTime currentTime = LocalTime.of(startingHour, startingMinute);
        LocalTime endTime = LocalTime.of(endingHour, endingMinute);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        while (currentTime.isBefore(endTime)) {
            // Check if current time is within any break
            LocalTime slotEndTime = currentTime.plusMinutes(appointmentDuration);
            
            boolean isBreakTime = isTimeInBreak(currentTime)||isTimeInBreak(slotEndTime);
            
            if (!isBreakTime) {
                
                
                // Ensure slot doesn't extend beyond end time or into a break
                if (slotEndTime.isBefore(endTime) ) {
                    AppointmentNode node = new AppointmentNode(
                            currentTime.format(formatter),
                            slotEndTime.format(formatter)
                    );
                    appointmentSlots.add(node);
                    currentTime = slotEndTime;
                } else {
                    break;
                }
            } else {
                // If it's break time, jump to the end of the break
                if (isTimeInBreak(slotEndTime)) {
                    currentTime=slotEndTime;
                    currentTime = getNextAvailableTimeAfterBreak(currentTime);
                }else  currentTime = getNextAvailableTimeAfterBreak(currentTime);
                
            }
        }

        return appointmentSlots;
    }

    private static boolean isTimeInBreak(LocalTime time) {
        for (BreakTime breakTime : breakTimes) {
            if (time.isAfter(breakTime.start) && time.isBefore(breakTime.end)) {
                return true;
            }
        }
        return false;
    }

    private static LocalTime getNextAvailableTimeAfterBreak(LocalTime currentTime) {
        for (BreakTime breakTime : breakTimes) {
            if ((!currentTime.isBefore(breakTime.start) && currentTime.isBefore(breakTime.end))) {
                return breakTime.end;
            }
        }
        return currentTime;
    }
    
    
    private static void parseTimeInput(String input) {
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
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

<<<<<<< HEAD
    private void validateTimeInputs() {
=======
   
    private static void useDefaultTimes() {
        LocalTime defaultStart = LocalTime.parse(START_HOUR_DEFAULT);
        LocalTime defaultEnd = LocalTime.parse(END_HOUR_DEFAULT);

        startingHour = defaultStart.getHour();
        startingMinute = defaultStart.getMinute();
        endingHour = defaultEnd.getHour();
        endingMinute = defaultEnd.getMinute();
    }


    
   public static void appointmentCancel(int selected) {
        if (selected >= 0 && selected < appointmentSlots.size()) {
            appointmentSlots.remove(selected);
        }
    } 
    
      private static class BreakTime {
        LocalTime start;
        LocalTime end;

        BreakTime(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private static void validateTimeInputs() {
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
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

<<<<<<< HEAD
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

=======
>>>>>>> c1c3f129e5d97fdd922a43c50a088a12756c6303
}
