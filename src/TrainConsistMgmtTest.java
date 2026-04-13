import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TrainConsistMgmtTest {

    private int calculateTotalCapacity(List<TrainConsistMgmt.Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("AC Chair", 56),
                new TrainConsistMgmt.Bogie("First Class", 24),
                new TrainConsistMgmt.Bogie("Sleeper", 70)
        );
        int total = calculateTotalCapacity(bogies);
        assertEquals(222, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("AC Chair", 50),
                new TrainConsistMgmt.Bogie("AC Chair", 60)
        );
        int total = calculateTotalCapacity(bogies);
        assertEquals(110, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("First Class", 24)
        );
        int total = calculateTotalCapacity(bogies);
        assertEquals(24, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        int total = calculateTotalCapacity(bogies);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 100)
        );
        int total = calculateTotalCapacity(bogies);
        assertEquals(100, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("B1", 10),
                new TrainConsistMgmt.Bogie("B2", 20),
                new TrainConsistMgmt.Bogie("B3", 30)
        );
        int total = calculateTotalCapacity(bogies);
        assertEquals(60, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistMgmt.Bogie> bogies = new ArrayList<>(Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("AC Chair", 56)
        ));

        calculateTotalCapacity(bogies);

        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals(72, bogies.get(0).capacity);
    }
}