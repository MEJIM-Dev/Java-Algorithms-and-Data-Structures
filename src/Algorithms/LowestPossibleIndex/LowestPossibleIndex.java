package Algorithms.LowestPossibleIndex;

public class LowestPossibleIndex {

    public static int Solution(int[] arg){

        int match = -1;
        int startingPoint = Math.round(arg.length/2);
        int currentPoint = startingPoint;

        long startTime = System.nanoTime();
        while (currentPoint>=0){
//            System.out.println("down");
            if(arg[currentPoint]==currentPoint){
//                System.out.println("down match "+currentPoint);
                match=currentPoint;
            }
            currentPoint--;
        }

        if(currentPoint==-1&&match==-1){
            currentPoint=startingPoint+1;

            while (currentPoint<arg.length){
//                System.out.println("up");
                if(arg[currentPoint]==currentPoint){
//                    System.out.println("up match "+currentPoint);
                    match=currentPoint;
                    break;
                }
                currentPoint++;
            }
        }
        long finishTime = System.nanoTime();
        System.out.println(finishTime-startTime);

        return match;
    }


    public static int BruteForceSolution(int[] arg){
        int match = -1;
        int i = 0;

        long startTime = System.nanoTime();
        while (i<arg.length){
            if(arg[i]==i){
                match=i;
                break;
            }
            i++;
        }
        long finishTime = System.nanoTime();
        System.out.println(finishTime-startTime);
        return match;
    }
}
