/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CurrentlyImproving;

/**
 *
 * @author ysr
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class AppointmentDayPlanner {
    private Scanner input;
    private ArrayList<AppointmentDay> selectedDaysFromDoctor;

    public AppointmentDayPlanner() {
        this.input = new Scanner(System.in);
        this.selectedDaysFromDoctor = new ArrayList<>();
    }

    /**
     * Allows doctor to select available appointment days
     * @return List of selected AppointmentDay objects
     */
    public ArrayList<AppointmentDay> planAppointmentDays() {
        // Track already taken appointments
        Queue<LocalDateTime> alreadyTakenAppointments = getAlreadyTakenAppointments();

        // Get number of days to plan
        System.out.println("How many days are you going to plan?");
        int numberOfDaysToПлан = input.nextInt();
        input.nextLine(); // Consume newline

        // Display available days
        displayAvailableDays(numberOfDaysToПлан, alreadyTakenAppointments);

        // Get doctor's selected days
        System.out.println("Select the days you are free for appointments (input format: 1,2,3 or 1-5):");
        String selectedDays = input.nextLine();
        
        // Parse and validate selected days
        int[] selectedDaysArray = parseStringToIntegerArray(selectedDays);
        int[] validatedDaysArray = validateSelectedDays(selectedDaysArray, numberOfDaysToПлан);

        // Create and return appointment days
        return createAppointmentDays(validatedDaysArray);
    }

    /**
     * Retrieves already taken appointments from existing selected days
     * @return Queue of taken appointment dates
     */
    private Queue<LocalDateTime> getAlreadyTakenAppointments() {
        Queue<LocalDateTime> alreadyTakenAppointments = new LinkedList<>();
        
        if (!selectedDaysFromDoctor.isEmpty()) {
            for (AppointmentDay availableAppointmentDate : selectedDaysFromDoctor) {
                if (availableAppointmentDate.isAppointmentSelectedByManager) {
                    alreadyTakenAppointments.add(availableAppointmentDate.appointmentDate);
                }
            }
        }
        
        return alreadyTakenAppointments;
    }

    /**
     * Displays available days for appointment selection
     * @param numberOfDays Total number of days to display
     * @param takenAppointments Queue of already taken appointments
     */
    private void displayAvailableDays(int numberOfDays, Queue<LocalDateTime> takenAppointments) {
        for (int i = 1; i <= numberOfDays; i++) {
            LocalDateTime appointmentDate = LocalDateTime.now().plusDays(i);

            if (!takenAppointments.isEmpty() && compareDates(appointmentDate, takenAppointments.peek())) {
                System.out.println(i + ". " + appointmentDate.format(DateTimeFormatter.ISO_DATE) + " IS ALREADY TAKEN!!!");
                takenAppointments.poll();
            } else {
                System.out.println(i + ". " + appointmentDate.format(DateTimeFormatter.ISO_DATE));
            }
        }
    }

    /**
     * Validates selected days against total number of days
     * @param selectedDays Array of selected days
     * @param totalDays Total number of days available
     * @return Validated array of days
     */
    private int[] validateSelectedDays(int[] selectedDays, int totalDays) {
        for (int i = 0; i < selectedDays.length; i++) {
            if (selectedDays[i] > totalDays) {
                selectedDays[i] = -1;
            }
        }
        return selectedDays;
    }

    /**
     * Creates AppointmentDay objects for selected days
     * @param selectedAppointments Array of selected days
     * @return ArrayList of AppointmentDay objects
     */
    private ArrayList<AppointmentDay> createAppointmentDays(int[] selectedAppointments) {
        selectedDaysFromDoctor.clear(); // Clear previous selections
        
        for (int selectedAppointment : selectedAppointments) {
            if (selectedAppointment == -1) {
                continue; // Skip out-of-range selections
            }
            selectedDaysFromDoctor.add(new AppointmentDay(LocalDateTime.now().plusDays(selectedAppointment)));
        }
        
        return selectedDaysFromDoctor;
    }

    /**
     * Parses input string to integer array, supporting single numbers and ranges
     * @param input String of selected days
     * @return Array of selected days
     */
    public int[] parseStringToIntegerArray(String input) {
        List<Integer> result = new ArrayList<>();
        String[] parts = input.split(",");

        for (String part : parts) {
            if (part.contains("-")) {
                // Handle range (e.g., "5-8")
                String[] rangeParts = part.split("-");
                int start = Integer.parseInt(rangeParts[0]);
                int end = Integer.parseInt(rangeParts[1]);

                for (int i = start; i <= end; i++) {
                    result.add(i);
                }
            } else {
                // Handle single number (e.g., "1", "2")
                result.add(Integer.parseInt(part));
            }
        }

        // Convert List to int array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Compares two dates by their date component only
     * @param date1 First date to compare
     * @param date2 Second date to compare
     * @return true if dates are the same, false otherwise
     */
    public boolean compareDates(LocalDateTime date1, LocalDateTime date2) {
        LocalDate date1LocalDate = date1.toLocalDate();
        LocalDate date2LocalDate = date2.toLocalDate();

        return date1LocalDate.equals(date2LocalDate);
    }
    
    
    /**
     * Getter for selected days
     * @return List of selected AppointmentDay objects
     */
    public ArrayList<AppointmentDay> getSelectedDays() {
        return selectedDaysFromDoctor;
    }
}