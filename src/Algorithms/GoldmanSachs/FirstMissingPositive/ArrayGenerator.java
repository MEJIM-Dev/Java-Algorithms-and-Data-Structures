package Algorithms.GoldmanSachs.FirstMissingPositive;

import java.util.Random;
import java.util.Arrays; // For printing the arrays in main

public class ArrayGenerator {

    private static final Random RANDOM = new Random();

    /**
     * Generates a random integer array suitable for the "First Missing Positive" problem.
     * The array length will be between minLength and maxLength (inclusive).
     * The elements will be random integers across the full range of `int`
     * (from Integer.MIN_VALUE to Integer.MAX_VALUE), adhering to the problem's constraints.
     *
     * @param minLength The minimum desired length of the array (inclusive, must be >= 1).
     * @param maxLength The maximum desired length of the array (inclusive, must be <= 10^5).
     * @return A randomly generated integer array.
     * @throws IllegalArgumentException if minLength or maxLength are out of specified bounds or minLength > maxLength.
     */
    public static int[] generateRandomArray(int minLength, int maxLength) {
        if (minLength < 1 || maxLength > 100000 || minLength > maxLength) {
            throw new IllegalArgumentException("Array length constraints: 1 <= length <= 10^5, and minLength <= maxLength.");
        }

        // Generate a random length within the specified range
        int length = RANDOM.nextInt(maxLength - minLength + 1) + minLength;

        int[] nums = new int[length];

        // Fill the array with random integers across the full int range
        // This covers the problem's constraint: -2^31 <= nums[i] <= 2^31 - 1
        for (int i = 0; i < length; i++) {
            nums[i] = RANDOM.nextInt(); // Generates a random int over the full range
        }

        return nums;
    }

    /**
     * Generates a random integer array where elements are within a more constrained
     * symmetric range (e.g., -100 to 100). This can be helpful for testing scenarios
     * where the missing positive integer is expected to be relatively small,
     * or for debugging purposes.
     *
     * @param minLength The minimum desired length of the array (inclusive, must be >= 1).
     * @param maxLength The maximum desired length of the array (inclusive, must be <= 10^5).
     * @param absMaxValue The maximum absolute value for generated elements (e.g., 100, 1000).
     * Elements will be in the range [-absMaxValue, absMaxValue].
     * @return A randomly generated integer array.
     * @throws IllegalArgumentException if parameters are out of bounds or absMaxValue is not positive.
     */
    public static int[] generateRandomArrayWithBoundedValues(int minLength, int maxLength, int absMaxValue) {
        if (minLength < 1 || maxLength > 100000 || minLength > maxLength) {
            throw new IllegalArgumentException("Array length constraints: 1 <= length <= 10^5, and minLength <= maxLength.");
        }
        if (absMaxValue <= 0) {
            throw new IllegalArgumentException("absMaxValue must be positive.");
        }

        int length = RANDOM.nextInt(maxLength - minLength + 1) + minLength;
        int[] nums = new int[length];

        for (int i = 0; i < length; i++) {
            // Generates numbers from -absMaxValue to +absMaxValue
            nums[i] = RANDOM.nextInt(2 * absMaxValue + 1) - absMaxValue;
        }

        return nums;
    }

    public static void main(String[] args) {
        // --- Example Usage of the Array Generators ---

        // Test Case 1: Small array with values across the full int range
        System.out.println("--- Test Case 1: Small array, wide value range ---");
        int[] arr1 = generateRandomArray(5, 15);
        System.out.println("Generated Array: " + Arrays.toString(arr1));
        System.out.println("Length: " + arr1.length + "\n");

        // Test Case 2: Larger array with values bounded around 0 for easier debugging
        System.out.println("--- Test Case 2: Larger array, bounded values (-50 to 50) ---");
        int[] arr2 = generateRandomArrayWithBoundedValues(20, 50, 50);
        System.out.println("Generated Array (first 20 elements): " + Arrays.toString(Arrays.copyOfRange(arr2, 0, Math.min(arr2.length, 20))));
        System.out.println("Length: " + arr2.length + "\n");

        // Test Case 3: Array near the maximum length constraint
        System.out.println("--- Test Case 3: Array near max length (approx. 10^5) ---");
        int[] arr3 = generateRandomArray(99990, 100000);
        System.out.println("Generated Array Length: " + arr3.length);
        // Warning: Do not try to print very large arrays using Arrays.toString(), it can cause OutOfMemoryError
        // System.out.println("Generated Array: " + Arrays.toString(arr3)); // Uncomment with caution for very large arrays
    }
}
