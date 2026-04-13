import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistMgmtTest {

    private List<TrainConsistMgmt.Bogie> getTestBogies() {
        List<TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistMgmt.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistMgmt.Bogie("First Class", 24));
        bogies.add(new TrainConsistMgmt.Bogie("Sleeper", 70));
        return bogies;
    }

    private List<TrainConsistMgmt.Bogie> filterUsingLoop(List<TrainConsistMgmt.Bogie> bogies) {
        List<TrainConsistMgmt.Bogie> result = new ArrayList<>();
        for (TrainConsistMgmt.Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    private List<TrainConsistMgmt.Bogie> filterUsingStream(List<TrainConsistMgmt.Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistMgmt.Bogie> bogies = getTestBogies();
        List<TrainConsistMgmt.Bogie> result = filterUsingLoop(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistMgmt.Bogie> bogies = getTestBogies();
        List<TrainConsistMgmt.Bogie> result = filterUsingStream(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistMgmt.Bogie> bogies = getTestBogies();
        List<TrainConsistMgmt.Bogie> loopResult = filterUsingLoop(bogies);
        List<TrainConsistMgmt.Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        filterUsingLoop(getTestBogies());
        long end = System.nanoTime();
        long duration = end - start;

        assertTrue(duration > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistMgmt.Bogie> largeList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            largeList.add(new TrainConsistMgmt.Bogie("TestType", 65));
        }

        List<TrainConsistMgmt.Bogie> result = filterUsingStream(largeList);
        assertEquals(100000, result.size());
    }
}