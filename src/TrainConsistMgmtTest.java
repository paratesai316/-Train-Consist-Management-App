import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            new TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new TrainConsistMgmt.PassengerBogie("AC Chair", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new TrainConsistMgmt.PassengerBogie("First Class", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        TrainConsistMgmt.InvalidCapacityException exception = assertThrows(
                TrainConsistMgmt.InvalidCapacityException.class,
                () -> new TrainConsistMgmt.PassengerBogie("Sleeper", -5)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistMgmt.InvalidCapacityException {
        TrainConsistMgmt.PassengerBogie bogie = new TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new TrainConsistMgmt.PassengerBogie("Sleeper", 72);
            new TrainConsistMgmt.PassengerBogie("AC Chair", 56);
            new TrainConsistMgmt.PassengerBogie("First Class", 24);
        });
    }
}import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            new TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new TrainConsistMgmt.PassengerBogie("AC Chair", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(TrainConsistMgmt.InvalidCapacityException.class, () -> {
            new TrainConsistMgmt.PassengerBogie("First Class", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        TrainConsistMgmt.InvalidCapacityException exception = assertThrows(
                TrainConsistMgmt.InvalidCapacityException.class,
                () -> new TrainConsistMgmt.PassengerBogie("Sleeper", -5)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistMgmt.InvalidCapacityException {
        TrainConsistMgmt.PassengerBogie bogie = new TrainConsistMgmt.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.type);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new TrainConsistMgmt.PassengerBogie("Sleeper", 72);
            new TrainConsistMgmt.PassengerBogie("AC Chair", 56);
            new TrainConsistMgmt.PassengerBogie("First Class", 24);
        });
    }
}