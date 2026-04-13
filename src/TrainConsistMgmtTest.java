import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistMgmt.GoodsBogie bogie = new TrainConsistMgmt.GoodsBogie("Cylindrical");
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistMgmt.GoodsBogie bogie = new TrainConsistMgmt.GoodsBogie("Rectangular");
        assertThrows(TrainConsistMgmt.CargoSafetyException.class, () -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistMgmt.GoodsBogie bogie = new TrainConsistMgmt.GoodsBogie("Rectangular");
        try {
            bogie.assignCargo("Petroleum");
        } catch (TrainConsistMgmt.CargoSafetyException e) {
            // Expected
        }
        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistMgmt.GoodsBogie bogie1 = new TrainConsistMgmt.GoodsBogie("Rectangular");
        TrainConsistMgmt.GoodsBogie bogie2 = new TrainConsistMgmt.GoodsBogie("Cylindrical");

        try {
            bogie1.assignCargo("Petroleum");
        } catch (TrainConsistMgmt.CargoSafetyException e) {
            // Handled
        }

        assertDoesNotThrow(() -> bogie2.assignCargo("Petroleum"));
        assertEquals("Petroleum", bogie2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistMgmt.GoodsBogie bogie = new TrainConsistMgmt.GoodsBogie("Rectangular");

        boolean catchExecuted = false;

        try {
            bogie.assignCargo("Petroleum");
        } catch (TrainConsistMgmt.CargoSafetyException e) {
            catchExecuted = true;
        }
        // The finally block is embedded in the class method itself and prints to standard out.
        // The fact that it throws the exception back to us (and we catch it) ensures the inner finally ran.
        assertTrue(catchExecuted);
    }
}