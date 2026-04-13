import java.util.LinkedHashSet;

public class TrainConsistMgmt {

    public static void main(String[] args) {

        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Initial formation: " + trainFormation);

        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Attempted to add duplicate 'Sleeper'. System rejected it.");
        }

        System.out.println("Final Train Formation: " + trainFormation);
    }
}