import java.util.ArrayList;
import java.util.List;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        // Example usage of the integer binary search
        int[] intArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int targetInt = 7;

        // Search integer array
        int indexFound = binarySearchRecursive(intArray, targetInt, 0, intArray.length - 1);
        System.out.println("Index found for integer: " + indexFound);

        // Example usage of the string binary search
        String[] stringArray = {"apple", "banana", "grape", "grape", "grape", "orange", "pear"};
        String targetString = "grape";

        // Search string array
        List<Integer> stringIndices = binarySearchAllIndices(stringArray, targetString, 0, stringArray.length - 1);
        System.out.println("Indices found for string: " + stringIndices);

        // Handle edge cases
        int[] emptyArray = {};
        int targetEdgeCase = 4;
        System.out.println("Searching an empty array result: " +
            binarySearchRecursive(emptyArray, targetEdgeCase, 0, emptyArray.length - 1));
    }

    /**
     * Recursive binary search for integers in a sorted array.
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        if (left > right) {
            return -1; // Base case: element not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Element found
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, left, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
    }

    /**
     * Recursive binary search for all occurrences of a target value in a sorted string array.
     */
    public static List<Integer> binarySearchAllIndices(String[] arr, String target, int left, int right) {
        List<Integer> indices = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        int index = binarySearchString(arr, target, left, right);

        if (index != -1) {
            // Search left of the index for duplicates
            int i = index;
            while (i >= 0 && arr[i].equals(target)) {
                indices.add(i);
                i--;
            }

            // Search right of the index for duplicates
            i = index + 1;
            while (i < arr.length && arr[i].equals(target)) {
                indices.add(i);
                i++;
            }
        }

        return indices;
    }

    /**
     * Helper method for binary search on string arrays.
     */
    public static int binarySearchString(String[] arr, String target, int left, int right) {
        if (left > right) {
            return -1; // Base case: element not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid].equals(target)) {
            return mid; // Element found
        } else if (arr[mid].compareTo(target) > 0) {
            return binarySearchString(arr, target, left, mid - 1);
        } else {
            return binarySearchString(arr, target, mid + 1, right);
        }
    }
}
