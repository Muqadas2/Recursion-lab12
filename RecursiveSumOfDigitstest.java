import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursiveSumOfDigitsTest {

    @Test
    public void testZero() {
        assertEquals(0, RecursiveSumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testSingleDigitNumber() {
        assertEquals(5, RecursiveSumOfDigits.sumOfDigits(5));
    }

    @Test
    public void testPositiveNumber() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(123));
    }

    @Test
    public void testNegativeNumber() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(-123));
    }

    @Test
    public void testLargeNumber() {
        assertEquals(45, RecursiveSumOfDigits.sumOfDigits(987654321));
    }

    @Test
    public void testVeryLargeNegativeNumber() {
        assertEquals(45, RecursiveSumOfDigits.sumOfDigits(-987654321));
    }

    @Test
    public void testEdgeCaseEmptyNumber() {
        assertEquals(0, RecursiveSumOfDigits.sumOfDigits(0));
    }

    @Test
    public void testEdgeCaseLargeSingle Digits() {
        assertEquals(36, RecursiveSumOfDigits.sumOfDigits(111111111));
    }
}
