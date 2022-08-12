package Algorithms.FibunachiSequence;

import java.util.HashMap;
import java.util.Map;

public class FibunachiSequence {

    static Map map = new HashMap();

    public static long FBAdditionForward(int num){
        if(num<=1) {
            map.put(num, num-1);
            return num;
        }
        if(map.containsKey(num)){
            return (long)map.get(num);
        }
        long answer =  FBAdditionForward(num-1)+FBAdditionForward(num-2);
        map.put(num, answer);
        return answer;
    }

//    public static int FBRecursive(int num){
//        if(num<=1){
//            return 1;
//        }
//        return num*FBRecursive(num-1);
//    }
}
