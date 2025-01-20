package Algorithms.NeetCode.TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter List of numbers comma seperated... e.g: 2,3,4,7");
        String listAsString = scanner.next();
        System.out.println("Enter Target sum number");
        int sum = scanner.nextInt();
        scanner.close();

        String[] split = listAsString.split(",");
        int[] list = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            list[i] = Integer.parseInt(split[i]);
        }

        System.out.println("Solution: " + solution(list, sum));
    }

    public static ArrayList<Integer> solution(int[] args, int target){
        ArrayList<Integer> indexes = new ArrayList<>();
        Map<Integer, Integer> checks = new HashMap<>();

        for (int j = 0; j < args.length; j++) {
            int val = args[j];
            if (val > target) {
                continue;
            }

            int balance = target - val;
            boolean containsKey = checks.containsKey(balance);
            if(containsKey) {
                indexes.add( checks.get(balance) );
                indexes.add( j );
                return indexes;
            }

            checks.put(val, j);
        }

        return indexes;
    }
}
