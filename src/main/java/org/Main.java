package main.java.org;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JSONReader readerJSON = new JSONReader("D:\\testing\\input.json");
        ArrayList<String> expressions = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        MyCalc calculator = new MyCalc();
        expressions = readerJSON.GetExpressions();
        for (int i = 0; i < expressions.size(); i++) {
            System.out.println(expressions.get(i));
            results.add(Double.toString(calculator.GetResult(expressions.get(i))));
        }
        for (int i = 0; i < expressions.size(); i++) {
            System.out.println(results.get(i));
        }
        JSONWriter writerJSON = new JSONWriter("D:\\testing\\output.json");
        writerJSON.WriteExpression(results);




        expressions = new ArrayList<>();
        XMLReader  readerXML = new XMLReader("D:\\testing\\input.xml");
        expressions = readerXML.GetExpressions();
        results = new ArrayList<>();
        for (int i = 0; i < expressions.size(); i++) {
            System.out.println(expressions.get(i));
            results.add(Double.toString(calculator.GetResult(expressions.get(i))));
        }
        XMLWriter writerXML = new XMLWriter("D:\\testing\\output.xml");
        try {
            writerXML.WriteExpression(results);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }





        JSONReaderNonAPI nonAPI = new JSONReaderNonAPI("D:\\testing\\input.json");
        expressions = nonAPI.GetExpressions();
        for (int i = 0; i < expressions.size(); i++) {
            System.out.println(expressions.get(i));
        }
        System.out.println("=============================");
        XMLReaderNonAPI readerNonAPI = new XMLReaderNonAPI("D:\\testing\\input.xml");
        expressions = readerNonAPI.GetExpressions();
        for (int i = 0; i < expressions.size(); i++) {
            System.out.println(expressions.get(i));
        }
    }
}