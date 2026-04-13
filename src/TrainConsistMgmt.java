import java.util.HashSet;
import java.util.Set;


public class TrainConsistMgmt {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Initializing Bogie ID Tracking System...\n");

                Set<String> bogieIds = new HashSet<>();


        System.out.println("Registering Bogie ID: BG101");
        bogieIds.add("BG101");

        System.out.println("Registering Bogie ID: BG102");
        bogieIds.add("BG102");

        System.out.println("Registering Bogie ID: BG103");
        bogieIds.add("BG103");

        System.out.println("Attempting to register Bogie ID: BG101 again...");


        boolean isAdded = bogieIds.add("BG101");

        if (!isAdded) {
            System.out.println(" -> System Alert: Duplicate ID 'BG101' rejected. Ensures unique formation.");
        }
        System.out.println("\nFinal Registered Bogie IDs:");

        System.out.println(bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());
        System.out.println("------------------------------------");
    }
}