import java.util.ArrayList;
import java.util.List;

/**
 * UC1: Initialize Train and Display Consist Summary
 * This class serves as the entry point for the Train Consist Management App.
 * It demonstrates class structure, the main method, and dynamic collections.
 */
public class TrainConsistMgmt {

    public static void main(String[] args) {
        // 1. Display Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // 2. Initialize the Train Consist
        // We use the List interface with ArrayList for dynamic resizing
        // The list is currently empty as no bogies have been attached yet
        List<String> trainConsist = new ArrayList<>();

        // 3. Display Initial Consist Summary
        System.out.println("Initializing train consist...");

        // Using .size() to show the current count of bogies in the ArrayList
        System.out.println("Initial bogie count: " + trainConsist.size());

        // 4. Foundation for future Use Cases
        System.out.println("System ready for bogie assignment.");
        System.out.println("------------------------------------");
    }
}