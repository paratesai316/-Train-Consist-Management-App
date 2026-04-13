import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistMgmtTest {

    private boolean validateTrainID(String trainId) {
        Pattern pattern = Pattern.compile("^TRN-\\d{4}$");
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    private boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile("^PET-[A-Z]{2}$");
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(validateTrainID("TRN-1234"));
        assertTrue(validateTrainID("TRN-9999"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(validateTrainID("TRAIN12"));
        assertFalse(validateTrainID("TRN12A"));
        assertFalse(validateTrainID("1234-TRN"));
        assertFalse(validateTrainID("TRN-123A"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(validateCargoCode("PET-AB"));
        assertTrue(validateCargoCode("PET-ZZ"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(validateCargoCode("PET-ab"));
        assertFalse(validateCargoCode("PET123"));
        assertFalse(validateCargoCode("AB-PET"));
        assertFalse(validateCargoCode("PET-A1"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(validateTrainID("TRN-123"));
        assertFalse(validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(validateCargoCode("PET-Ab"));
        assertFalse(validateCargoCode("PET-aB"));
        assertFalse(validateCargoCode("pet-AB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(validateTrainID(""));
        assertFalse(validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(validateTrainID("TRN-1234 "));
        assertFalse(validateTrainID(" TRN-1234"));
        assertFalse(validateCargoCode("PET-ABC"));
        assertFalse(validateCargoCode("XPET-AB"));
    }
}