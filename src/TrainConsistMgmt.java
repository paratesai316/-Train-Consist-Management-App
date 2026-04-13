import java.util.ArrayList;

public class TrainConsistMgmt {

    public static void main(String[] args) {

        // 1. Create an ArrayList<String> for passenger bogies
        ArrayList<String> passengerBogies = new ArrayList<>();

        // 2. Add bogies: Sleeper, AC Chair, First Class
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. Print the list after insertion
        System.out.println("Initial Passenger Bogies: " + passengerBogies);

        // 4. Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");
        System.out.println("Bogie removed. Updated List: " + passengerBogies);

        // 5. Use contains() to check if Sleeper exists
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Does consist contain 'Sleeper'? " + hasSleeper);

        // 6. Print final list state
        System.out.println("Final list state: " + passengerBogies);
    }
}