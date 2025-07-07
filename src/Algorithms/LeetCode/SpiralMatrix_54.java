package Algorithms.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiralMatrix_54 {

    List<List<Integer>> Solution (List<List<Integer>> matrix){

        List<String> directions = List.of("right", "down", "left", "up");
        Map<Integer,Integer> visited = new HashMap<>();

        boolean done = false;
        int horizontal = 0;
        int vertical = 0;
        int directionIndex = 0;

        int[] res = new int[matrix.size()];
        int count = 0;

        while (done){
            if(directionIndex==0){
                List<Integer> list = matrix.get(horizontal);
                if(list == null || list.size()==0){
                    directionIndex = 1;
                } else {
//                    Integer removed = list.remove(0);//visited.
//                    res[count] = removed;
                    if(visited.containsKey(horizontal) && visited.get(horizontal).equals(vertical)){
                        //
                    }
                    visited.put(horizontal, vertical);
                    vertical++;

                }
            }
            if(directionIndex==1){

            }
            if(directionIndex==2){

            }
            if(directionIndex==3){

            }
            count++;
        }

        return null;
    }
}
