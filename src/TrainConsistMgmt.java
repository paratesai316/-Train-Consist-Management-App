import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + name + " | Capacity: " + capacity;
    }
}

public class TrainConsistMgmt {

    public static void main(String[] args) {

        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("Before Sorting:");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }

        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\nAfter Sorting by Capacity (High to Low):");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }
    }
}