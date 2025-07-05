package Algorithms.GoldmanSachs.FirstMissingPositive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {

    // Method to solve the First Missing Positive problem (you will write this)
    public int firstMissingPositive(int[] nums) {
        // Your O(n) time and O(1) auxiliary space solution goes here

        int[] possibleOutComes = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            //Positive check
            if(currentValue>0) {
                //smaller check
                if(currentValue-1 >= 0 && currentValue-1 < nums.length){
                    possibleOutComes[currentValue-1] = 1;
                }
            }
        }

        for (int i = 0; i < possibleOutComes.length; i++) {
            if(possibleOutComes[i]==0){
                return i+1;
            }
        }

        return nums.length+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive solver = new FirstMissingPositive();

        // Use the generator methods to create test cases
        int[] testCase1 = ArrayGenerator.generateRandomArrayWithBoundedValues(5, 10, 10);
        System.out.println("Test Case 1 Input: " + Arrays.toString(testCase1));
        int result1 = solver.firstMissingPositive(testCase1);
        System.out.println("Test Case 1 Output: " + result1);
        // Add assertions or manual checks for correctness

        int[] testCase2 = new int[]{1, 2, 0}; // Example from problem
        System.out.println("Test Case 2 Input: " + Arrays.toString(testCase2));
        int result2 = solver.firstMissingPositive(testCase2);
        System.out.println("Test Case 2 Output: " + result2);

    }
}
