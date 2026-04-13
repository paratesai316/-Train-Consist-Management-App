import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistMgmtTest {

    private List<TrainConsistMgmt.Bogie> filterBogies(List<TrainConsistMgmt.Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("AC Chair", 56)
        );
        List<TrainConsistMgmt.Bogie> result = filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 70)
        );
        List<TrainConsistMgmt.Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("First Class", 24),
                new TrainConsistMgmt.Bogie("AC Chair", 56)
        );
        List<TrainConsistMgmt.Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("General", 90),
                new TrainConsistMgmt.Bogie("First Class", 24)
        );
        List<TrainConsistMgmt.Bogie> result = filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("First Class", 24),
                new TrainConsistMgmt.Bogie("AC Chair", 56)
        );
        List<TrainConsistMgmt.Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("General", 90)
        );
        List<TrainConsistMgmt.Bogie> result = filterBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        List<TrainConsistMgmt.Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistMgmt.Bogie> bogies = new ArrayList<>(Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("AC Chair", 56)
        ));

        filterBogies(bogies, 60);

        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals("AC Chair", bogies.get(1).name);
    }
}