import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    private boolean searchBogie(String[] bogieIds, String searchId) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogieIds = {};
        assertThrows(IllegalStateException.class, () -> {
            searchBogie(bogieIds, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogieIds = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            searchBogie(bogieIds, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertTrue(searchBogie(bogieIds, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertFalse(searchBogie(bogieIds, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogieIds = {"BG101"};
        assertTrue(searchBogie(bogieIds, "BG101"));
    }
}
