import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TrainConsistMgmtTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};

        Arrays.sort(names);

        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] names = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};

        Arrays.sort(names);

        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] names = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};

        Arrays.sort(names);

        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] names = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};

        Arrays.sort(names);

        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] names = {"Sleeper"};
        String[] expected = {"Sleeper"};

        Arrays.sort(names);

        assertArrayEquals(expected, names);
    }
}