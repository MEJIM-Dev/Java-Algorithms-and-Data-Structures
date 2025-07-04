package Algorithms.GoldmanSachs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MaxAverage {

    public static String[][] generateStudentGrades() {
        // Predefined list of student names to choose from
        String[] studentNames = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Heidi"};

        // Random object for generating random numbers
        Random random = new Random();

        // Determine a random number of entries (rows) between 3 and 10
        // random.nextInt(8) generates a number from 0 to 7. Adding 3 makes it 3 to 10.
        int numberOfEntries = random.nextInt(8) + 3;

        // Initialize the 2D String array
        // Each inner array will have 2 elements: [name, grade]
        String[][] studentGrades = new String[numberOfEntries][2];

        // Populate the array with random student names and grades
        for (int i = 0; i < numberOfEntries; i++) {
            // Randomly select a student name
            String name = studentNames[random.nextInt(studentNames.length)];

            // Randomly generate a grade between 0 and 100 (inclusive)
            String grade = String.valueOf(random.nextInt(101)); // nextInt(101) generates 0-100

            // Assign the name and grade to the current row
            studentGrades[i][0] = name;
            studentGrades[i][1] = grade;
        }

        return studentGrades;
    }

    public static void main(String[] args) {
        // Example usage of the method
        String[][] gradesArray = generateStudentGrades();

        System.out.println("Generated Student Grades Array:");
        for (String[] entry : gradesArray) {
            System.out.println("[\"" + entry[0] + "\", \"" + entry[1] + "\"]");
        }
        System.out.println("Total entries: " + gradesArray.length);


        Map<String, List<Integer>> averages = new HashMap<>();
        int maxScore = 0;
        for (int i = 0; i < gradesArray.length; i++) {
            String[] item = gradesArray[i];
            String name = item[0];
            Integer score = Integer.parseInt(item[1]);

            if(averages.containsKey(name)){
                List<Integer> previous = averages.get(name);
                Integer sum = previous.get(0) + score;
                averages.replace(name, List.of(sum, previous.get(1)+1));
            } else{
                averages.put(name, List.of(score, 1));
            }
        }

        for (Map.Entry<String, List<Integer>> set: averages.entrySet()) {
            List<Integer> value = set.getValue();
            int avg = value.get(0)/value.get(1);
            if (maxScore<avg){
                maxScore = avg;
            }
        }

        System.out.println("Max Score: "+ maxScore);
    }


}
