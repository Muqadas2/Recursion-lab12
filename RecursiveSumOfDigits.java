public class RecursiveSumOfDigits {

    /**
     * Recursive function to compute the sum of digits of a number.
     * Handles both positive and negative numbers by taking their absolute value.
     * 
     * @param number The number whose digits will be summed.
     * @return The sum of the digits.
     */
    public static int sumOfDigits(int number) {
        // Convert number to positive if it's negative
        number = Math.abs(number);

        // Base case: if number is 0, return 0
        if (number == 0) {
            return 0;
        }

        // Recursive case: sum last digit + recursive call on the rest of the number
        return (number % 10) + sumOfDigits(number / 10);
    }

    public static void main(String[] args) {
        // Test with different numbers
        int[] testNumbers = {0, 123, -123, 987654321, -987654321};

        for (int num : testNumbers) {
            System.out.println("Sum of digits of " + num + ": " + sumOfDigits(num));
        }
    }
}
