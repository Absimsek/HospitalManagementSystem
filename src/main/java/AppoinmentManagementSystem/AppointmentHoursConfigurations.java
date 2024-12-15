package AppoinmentManagementSystem;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages appointment scheduling configurations, including 
 * generating appointment slots, handling break times, and managing appointments.
 */
public class AppointmentHoursConfigurations {

    // Default configuration constants
    public static final LocalTime START_HOUR_DEFAULT = LocalTime.of(9, 00);
    public static final LocalTime END_HOUR_DEFAULT = LocalTime.of(17, 00);
    public static final int DEFAULT_APPOINTMENT_DURATION = 30;
    public static final int BREAK_TIME_LENGTH = 60;
    public static final LocalTime DEFAULT_BREAK_START = LocalTime.of(12, 00);
    public static final LocalTime DEFAULT_BREAK_END = LocalTime.of(13, 00);

    // Configurable time ranges for appointments and breaks
    private static LocalTime[] startingAndEndingTimes = {START_HOUR_DEFAULT, END_HOUR_DEFAULT};
    private static LocalTime[] breakTimes = {DEFAULT_BREAK_START, DEFAULT_BREAK_END};

    /**
     * Generates appointment slots based on provided parameters.
     * 
     * @param timeRange Optional time range for appointments
     * @param appointmentDurationInput Duration of each appointment
     * @param breakTime Optional break time
     * @return List of generated appointment slots
     */
    public static List<AppointmentNode> generateAppointmentSlots(
            String timeRange, 
            String appointmentDurationInput, 
            String breakTime
    ) {
        // Determine appointment duration
        int appointmentDuration = appoinmentDurationDecider(appointmentDurationInput);

        // Parse and set break times if provided
        if (breakTime != null) {
            breakTimes = parseTimeInput(breakTime, breakTimes);
        }

        // Generate slots based on time range
        if (!timeRange.isEmpty()) {
            startingAndEndingTimes = parseTimeInput(timeRange, startingAndEndingTimes);
            return createAppointmentSlotsWithBreaks(appointmentDuration);
        } else {
            return createAppointmentSlotsWithBreaks(appointmentDuration);
        }
    }

    /**
     * Creates appointment slots, considering break times and available hours.
     * 
     * @param appointmentDuration Length of each appointment in minutes
     * @return List of appointment slots
     */
    private static List<AppointmentNode> createAppointmentSlotsWithBreaks(int appointmentDuration) {
        // Start from the beginning of the day's available hours
        LocalTime currentTime = startingAndEndingTimes[0];
        
        // Create a list to store appointment slots
        List<AppointmentNode> appointmentSlots = new ArrayList<>();
        
        // Formatter for time display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
        
        // Generate slots until end of available hours
        while (currentTime.isBefore(startingAndEndingTimes[1])) {
            // Calculate potential slot end time
            LocalTime slotEndTime = currentTime.plusMinutes(appointmentDuration);
            
            // Check if current or end time falls within break time
            boolean isBreakTime = isTimeInBreak(currentTime) || isTimeInBreak(slotEndTime);
            
            if (!isBreakTime) {
                // Ensure slot doesn't extend beyond end time or into a break
                if (slotEndTime.isBefore(startingAndEndingTimes[1])) {
                    // Create and add appointment node
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
                // If it's break time, move to next available time
                if (isTimeInBreak(slotEndTime)) {
                    currentTime = slotEndTime;
                    currentTime = getNextAvailableTimeAfterBreak(currentTime);
                } else {
                    currentTime = getNextAvailableTimeAfterBreak(currentTime);
                }
            }
        }

        return appointmentSlots;
    }

    /**
     * Checks if a given time falls within the break period.
     * 
     * @param time Time to check
     * @return True if time is during break, false otherwise
     */
    private static boolean isTimeInBreak(LocalTime time) {
        return (!time.isBefore(breakTimes[0]) && time.isBefore(breakTimes[1]));
    }

    /**
     * Gets the next available time after a break period.
     * 
     * @param currentTime Current time being processed
     * @return Next available time after break
     */
    private static LocalTime getNextAvailableTimeAfterBreak(LocalTime currentTime) {
        if ((!currentTime.isBefore(breakTimes[0]) && currentTime.isBefore(breakTimes[1]))) {
            return breakTimes[1];
        }
        return currentTime;
    }

    
    /**
     * Deletes appointments within a specified time interval.
     * Whenever interval is wrong in order to keep order of appoinments it's sets interval to default break time
     * 
     * @param interval Time interval for deletion
     * @param appointmentNodes List of appointment nodes to process
     * @return Updated list of appointment nodes
     */
    public static List<AppointmentNode> deleteAppointmentsInInterval(
            String interval, 
            List<AppointmentNode> appointmentNodes
    ) {
        // Parse the interval to get start and end times
        LocalTime[] deletionInterval = parseTimeInput(interval, breakTimes);
        
        // Safely remove appointments within the specified interval
        appointmentNodes.removeIf(appointmentNode -> {
            LocalTime nodeStartTime = LocalTime.parse(
                appointmentNode.getStartTime(), 
                DateTimeFormatter.ofPattern("HH.mm")
            );
            return !nodeStartTime.isBefore(deletionInterval[0]) && 
                   nodeStartTime.isBefore(deletionInterval[1]);
        });
        
        return appointmentNodes;
    }

    /**
     * Cancels a specific appointment by its index.
     * 
     * @param selected Index of the appointment to cancel
     * @param appointmentNodes List of appointment nodes
     */
    public static void appointmentCancel(int selected, List<AppointmentNode> appointmentNodes) {
        if (selected >= 0 && selected < appointmentNodes.size()) {
            appointmentNodes.remove(selected);
        }
    } 
    
      /**
     * Determines the appointment duration based on input.
     * If no duration is provided, uses the default duration.
     * 
     * @param appointmentDuration Duration input as a string
     * @return Parsed appointment duration in minutes
     */
    private static int appoinmentDurationDecider(String appointmentDuration) {
        return appointmentDuration.isEmpty()
                ? AppointmentHoursConfigurations.DEFAULT_APPOINTMENT_DURATION
                : Integer.parseInt(appointmentDuration);
    }
    
    /**
     * Parses time input and returns an array of start and end times.
     * Falls back to default times if parsing fails.
     * 
     * @param input Time range input (e.g., "09.00-17.00")
     * @param defaultHours Default time range to use if parsing fails
     * @return Array of start and end times
     */
    private static LocalTime[] parseTimeInput(String input, LocalTime[] defaultHours) {
        LocalTime[] startingAndEnding = new LocalTime[2];
        try {
            String[] timeParts = input.split("-");
            if (timeParts.length != 2) {
                throw new IllegalArgumentException("Invalid time format. Use HH.mm-HH.mm");
            }

            startingAndEnding[0] = LocalTime.parse(timeParts[0], DateTimeFormatter.ofPattern("HH.mm"));
            startingAndEnding[1] = LocalTime.parse(timeParts[1], DateTimeFormatter.ofPattern("HH.mm"));

        } catch (Exception e) {
            System.out.println("Time parsing error: " + e.getMessage());
            // Use default hours if parsing fails
            startingAndEnding[0] = defaultHours[0];
            startingAndEnding[1] = defaultHours[1];
        }
        return startingAndEnding;
    }

}