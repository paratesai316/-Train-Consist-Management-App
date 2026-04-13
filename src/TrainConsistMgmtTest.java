import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class TrainConsistMgmtTest {

    private boolean checkSafetyCompliance(List<TrainConsistMgmt.GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum")
        );
        assertTrue(checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmt.GoodsBogie("Open", "Coal"),
                new TrainConsistMgmt.GoodsBogie("Box", "Grain"),
                new TrainConsistMgmt.GoodsBogie("Flat", "Steel")
        );
        assertTrue(checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistMgmt.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistMgmt.GoodsBogie("Open", "Coal"),
                new TrainConsistMgmt.GoodsBogie("Cylindrical", "Grain")
        );
        assertFalse(checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistMgmt.GoodsBogie> bogies = new ArrayList<>();
        assertTrue(checkSafetyCompliance(bogies));
    }
}