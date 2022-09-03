package Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EgyptianFractions {
    static Map<Integer,String> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextInt();
        double den = scanner.nextInt();
        scanner.close();
        egpyt(num,den);
        System.out.println(map);
    }

    public static void egpyt(double num, double den) {
        double denn= 0;
        double numm = 0;
        if(den%num==0) {
            map.put(map.size(), "1/"+String.valueOf((int)Math.ceil(den/num)));
            return;
        }
        map.put(map.size(), "1/" + String.valueOf((int)Math.ceil(den / num)));
        denn = den * Math.ceil(den/num);
        numm = num - 1;
        egpyt(numm,denn);
    }
}
