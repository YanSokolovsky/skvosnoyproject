package main.java.org;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String g;
        g = in.nextLine();
        System.out.println(g);
        MyCalc p = new MyCalc();
        double a = p.GetResult(g);
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(a);
        CalcWithLib lib = new CalcWithLib();
        double r = lib.Calculate(g);
        System.out.println(r);
        TXTReader n = new TXTReader("D:\\input.txt");
        Vector<String> rt = n.GetExpretions();
        RegexCalc calc = new RegexCalc();
        for (int i = 0; i < rt.size(); i++) {
            rt.set(i, calc.Calculating(rt.elementAt(i)).toString());
            System.out.println(calc.Calculating(rt.elementAt(i)));
        }
        TXTWriter tw = new TXTWriter(rt, "D:\\output.txt");
        tw.WriteExpressions(false);
    }
}