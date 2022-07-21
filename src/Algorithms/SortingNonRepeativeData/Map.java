package Algorithms.SortingNonRepeativeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map {

    public static void main(String[] args) {

    }

    public static void SortIntoAMapWithIncreasingValueForEachRepeatition(){
        java.util.Map sorted = new HashMap();

        int[] ints = RandomIntegerNumberGenerator(14);

        for (int j = 0; j < ints.length; j++) {
            int i = ints[j];
            if(sorted.containsKey(i)){
                int oldvalue = (int)sorted.get(i);
                sorted.replace(i, ++oldvalue);
                continue;
            }
            sorted.put(i, 1);
        }

        List<Integer> list = new ArrayList<>();

        Arrays.stream(ints).forEach(e->{ list.add(e);});

        System.out.println(list);
        System.out.println(sorted);
    }

    private static int[] RandomIntegerNumberGenerator(int repeat) {

        int[] ints = new int[repeat];

        for (int j = 0; j < repeat; j++) {
            Double aDouble = Math.floor(Math.random()*10);
            int intValue = aDouble.intValue();
            ints[j]=intValue;
        }

        return ints;
    }


}
