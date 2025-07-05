package DataStructures.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int maxSum = 0;
        for (int i = 0; i < arr.size()-2; i++){
            List<Integer> hourTop = arr.get(i);
            List<Integer> hourMid = arr.get(i+1);
            List<Integer> hourBottom = arr.get(i+2);

            for(int j = 0; j < hourTop.size()-2; j++){
                int sum = hourTop.get(j) + hourTop.get(j+1) + hourTop.get(j+2) + hourMid.get(j+
                        1) + hourBottom.get(j) + hourBottom.get(j+1) + hourBottom.get(j+2);

                if(sum > maxSum) {
                    maxSum = sum;
                }
            }

        }
        return maxSum;
    }

}

public class HourGlass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
