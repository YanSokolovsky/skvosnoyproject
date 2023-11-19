package main.java.org;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String g;
        g = in.nextLine();
        System.out.println(g);
        MyCalc p = new MyCalc();
        int a = p.GetResult(g);
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(a);
        CalcWithLib lib = new CalcWithLib();
        Integer r = lib.Calculate(g);
        System.out.println(r);
    }
}