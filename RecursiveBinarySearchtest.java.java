import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RecursiveBinarySearchTest {

    @Test
    public void testIntegerBinarySearch() {
        int[] intArray = {1, 3, 5, 7, 9, 11, 13, 15};
        assertEquals(3, RecursiveBinarySearch.binarySearchRecursive(intArray, 7, 0, intArray.length - 1));
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(intArray, 8, 0, intArray.length - 1));
    }

    @Test
    public void testStringBinarySearch() {
        String[] stringArray = {"apple", "banana", "grape", "grape", "grape", "orange", "pear"};
        List<Integer> indices = RecursiveBinarySearch.binarySearchAllIndices(stringArray, "grape", 0, stringArray.length - 1);
        assertTrue(indices.contains(2));
        assertTrue(indices.contains(3));
        assertTrue(indices.contains(4));
        assertEquals(3, indices.size());
    }

    @Test
    public void testStringBinarySearch_NoMatches() {
        String[] stringArray = {"apple", "banana", "grape", "grape", "grape", "orange", "pear"};
        List<Integer> indices = RecursiveBinarySearch.binarySearchAllIndices(stringArray, "kiwi", 0, stringArray.length - 1);
        assertTrue(indices.isEmpty());
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = {};
        assertThrows(IllegalArgumentException.class, () -> {
            RecursiveBinarySearch.binarySearchRecursive(emptyArray, 4, 0, emptyArray.length - 1);
        });
    }

    @Test
    public void testNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            RecursiveBinarySearch.binarySearchRecursive(null, 5, 0, -1);
        });
    }

    @Test
    public void testStringEmptyArray() {
        String[] emptyStringArray = {};
        assertThrows(IllegalArgumentException.class, () -> {
            RecursiveBinarySearch.binarySearchAllIndices(emptyStringArray, "grape", 0, -1);
        });
    }
}
