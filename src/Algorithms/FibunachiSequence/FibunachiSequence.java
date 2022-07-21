package Algorithms.FibunachiSequence;

public class FibunachiSequence {

    public static int FBSubtractionBackwards(int num){
        if(num>=3) {
            return FBSubtractionBackwards(num-1) + FBSubtractionBackwards(num-2);
        }
        return 1;
    }

    public static int FBMultiForward(int num){
        return num*(num-1);
    }

    public static int FBAdditionForward(int num){
        if(num<=1) return 1;
        return num+FBAdditionForward(num-1);
    }

//    public static int FBRecursive(int num){
//        if(num<=1){
//            return 1;
//        }
//        return num*FBRecursive(num-1);
//    }
}
