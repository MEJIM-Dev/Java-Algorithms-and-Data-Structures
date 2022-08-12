package Algorithms.FibunachiSequence;

import java.util.HashMap;
import java.util.Map;

public class FibunachiSequence {
    static Map map = new HashMap();

    public static int FBSubtractionBackwards(int num){
        if(num>=3) {
            return FBSubtractionBackwards(num-1) + FBSubtractionBackwards(num-2);
        }
        return 1;
    }

    public static int FBMultiForward(int num){
        return num*(num-1);
    }

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
