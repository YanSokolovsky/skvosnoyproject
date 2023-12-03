package main.java.org;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> vec;
        try {
            JSONReader rty = new JSONReader("D:\\in.json");
            vec = rty.GetExpressions();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (String s: vec) {
            System.out.println(s);
        }
        JSONWriter ert =  new JSONWriter();
        ert.WriteExpressions("234");
    }
}