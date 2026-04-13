import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistMgmtTest {

    private Map<String, List<TrainConsistMgmt.Bogie>> groupBogies(List<TrainConsistMgmt.Bogie> bogies) {
        return bogies.stream().collect(Collectors.groupingBy(b -> b.name));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("Sleeper", 70)
        );
        Map<String, List<TrainConsistMgmt.Bogie>> result = groupBogies(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("AC Chair", 56),
                new TrainConsistMgmt.Bogie("AC Chair", 60)
        );
        Map<String, List<TrainConsistMgmt.Bogie>> result = groupBogies(bogies);

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("AC Chair", 56)
        );
        Map<String, List<TrainConsistMgmt.Bogie>> result = groupBogies(bogies);

        assertEquals(2, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        Map<String, List<TrainConsistMgmt.Bogie>> result = groupBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("First Class", 24)
        );
        Map<String, List<TrainConsistMgmt.Bogie>> result = groupBogies(bogies);

        assertEquals(1, result.size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("AC Chair", 56),
                new TrainConsistMgmt.Bogie("First Class", 24)
        );
        Map<String, List<TrainConsistMgmt.Bogie>> result = groupBogies(bogies);

        assertTrue(result.keySet().containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("Sleeper", 70),
                new TrainConsistMgmt.Bogie("AC Chair", 56)
        );
        Map<String, List<TrainConsistMgmt.Bogie>> result = groupBogies(bogies);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<TrainConsistMgmt.Bogie> bogies = new ArrayList<>(Arrays.asList(
                new TrainConsistMgmt.Bogie("Sleeper", 72),
                new TrainConsistMgmt.Bogie("AC Chair", 56)
        ));

        groupBogies(bogies);

        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals("AC Chair", bogies.get(1).name);
    }
}