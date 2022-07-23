package DataStructures.Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Stacks {

    public static Stack<String> stack = new Stack<>();
    public static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args){
        Userinput();
    }

    public static <T> void Userinput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if(input.equals(".")){
            System.out.println(stack);
            return;
        }

        if(!ValidBracketCharacter(input)){
            System.out.println("Invalid bracket typed: "+ input);
            System.out.println(arrayList);
            System.out.println(stack);
            Userinput();
        } else{
//            System.out.println("valid");
            System.out.println(arrayList);
            System.out.println(stack);
            Userinput();
        }


    }

    public static <T> boolean ValidBracketCharacter(T input){
        ArrayList<String> brackets = new ArrayList<>(Arrays.asList("[","{","(","]","}",")"));
        int middleIndex=  brackets.size()<3?2:brackets.size()/2;

        if(stack.empty()){

            if(! (brackets.contains((String) input))){
                return false;
            }

            for (int i = middleIndex; i < brackets.size(); i++) {
                if(input.equals(brackets.get(i))){
                    return false;
                }
            }
            stack.push((String) input);
            arrayList.add((String) input);
        }
        else{

            if(! (brackets.contains((String) input))){
                return false;
            }

            String curr = stack.peek();
            int curIndex = brackets.indexOf(curr);
            int newIndex = brackets.indexOf(input);

            if(curIndex<middleIndex && newIndex<middleIndex || curIndex>=middleIndex && newIndex>=middleIndex){
                System.out.println("same angle");
                stack.push((String) input);
                arrayList.add((String) input);
                return true;
            }

            if(curIndex<middleIndex && newIndex>=middleIndex){
                System.out.println("different angle");
                if(curIndex ==0 && newIndex==3 || curIndex ==1 && newIndex==4 || curIndex ==2 && newIndex==5 ){
                    stack.pop();
                    arrayList.add((String) input);
                    return true;
                }
            }

            return false;
        }
        return true;
    }
}
