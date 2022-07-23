package Algorithms.StairCase;

import com.sun.source.tree.WhileLoopTree;

public class Staircase {

    public static void main(String[] args) {
        System.out.println("dezz nuts");

        TotalPossibleSteps(4, new int[]{1,2});
    }

    public static int Recursive(int currentStep, int[] possibleMoves, int totalPossibleSteps){
        int total = 0;
        if(currentStep==totalPossibleSteps-1){
            return 1;
        }
        total++;

        return total;
    }

    public static int TotalPossibleSteps(int totalStairs, int[] possibleSteps){
        int total = 0;

        for (int i = 0; i < possibleSteps.length; i++) {
            int currentStep = 0;
            while (currentStep<totalStairs){
                currentStep++;
            }
//            if(i<totalStairs){
//                total++;
//            }
//
//            i++;
        }
        return total;
    }
}
