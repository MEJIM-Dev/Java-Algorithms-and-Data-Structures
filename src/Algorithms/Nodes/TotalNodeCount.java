package Algorithms.Nodes;

import Algorithms.FibunachiSequence.FibunachiSequence;
import DataStructures.LinkedList.Node;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TotalNodeCount {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> nodeA = new Node<>(3);
        Node<Integer> nodeB = new Node<>(6);
        Node<Integer> nodeC = new Node<>(2);
        Node<Integer> nodeD = new Node<>(5);
        Node<Integer> nodeE = new Node<>(2);

        head.setNext(nodeA);
        nodeA.setNext(nodeB);
        nodeB.setNext(nodeC);
        nodeC.setNext(nodeD);
        nodeD.setNext(nodeE);

        System.out.println(FibunachiSequence.FBAdditionForward(3));

//        try {
//            System.out.println(TimeTakenToPerformATask("CounNodes", head));
//        } catch (InvocationTargetException e) {
//            System.out.println("InvocationTargetException");
//        } catch (IllegalAccessException e) {
//            System.out.println("IllegalAccessException");
//        } catch (NullPointerException e){
//            System.out.println("No such method present in this class");
//        }
    }

    public static <M,N> long TimeTakenToPerformATask(M methodName, N args) throws InvocationTargetException, IllegalAccessException {

         Method[] methods = TotalNodeCount.class.getDeclaredMethods();
        Method method = null;

        for (Method m:methods) {
            if(m.getName().equals(methodName)){
                method = m;
                break;
            }
        }

        if(method!=null){
            long startTime = System.nanoTime();
            method.invoke(new TotalNodeCount(), args);
            long endTime = System.nanoTime();
//            System.out.println(endTime-startTime);
            return endTime-startTime;
        }

        throw new NullPointerException();
    }

    public static void AverageRecursiveVsWhileLoop(){
//        int[] recursive= {268300,228600,164400,156600,155700,266900,189700,175600,270900,295500,181800};
        int[] whileMeth = {255000,422200,231800,353300,216200,652900,366700,234300,259100,307900,330400};
        System.out.println(Average(whileMeth));
    }

    public static int Average (int[] args){
        int sum = 0;
        int avg = 1;
        for (int i = 0; i < args.length; i++) {
            sum+=args[i];
        }
        avg =sum/args.length;
        return avg;
    }

    public static int CountNodes(Node head){
        if(head.getNext()==null) {
            return 1;
        }
        return CountNodes(head.getNext())+1;
    }

    public static int Factorial (int i){
        if(i<=0){
            return 1;
        }
        return i+1;
    }

    public static int  CountNodesWithAWhileLoop (Node node) {
        int count = 1;
        Node currentNode = node;

        while (currentNode.getNext()!=null){
            System.out.println("doing");
                currentNode=currentNode.getNext();
                count++;
        }
        return count;
    }
}
