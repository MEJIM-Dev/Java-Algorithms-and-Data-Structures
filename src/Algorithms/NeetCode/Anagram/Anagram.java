package Algorithms.NeetCode.Anagram;

import java.io.IOException;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Anagram Checker! Let's test how well words match. Type two words, and I'll tell you if they're anagrams!");
        System.out.println("Please input first word");
        String firstWord = scanner.next();
        System.out.println("Please input first word");
        String secondWord = scanner.next();
        scanner.close();

        boolean valid = isValid(firstWord, secondWord);
        if (valid) {
            System.out.println(String.format("Great! %s and %s are indeed anagrams! \uD83C\uDF89", firstWord, secondWord));
        } else {
            System.out.println(String.format("Oops! %s and %s are not anagrams. \uD83D\uDE15 Try again with different words!", firstWord, secondWord));
        }
    }

    public static boolean isValid(String arg1, String arg2) {
        if(arg1 == null || arg2 == null){
            return false;
        }

        if(arg1.length() != arg2.length()){
            return false;
        }

        int[] charCounts = new int[26];

        for (int i = 0; i < arg1.length(); i++) {
            charCounts[arg1.charAt(i) - 'a']++;
            charCounts[arg2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] != 0) {
                return false;
            }
        }

        return true;
    }


}
