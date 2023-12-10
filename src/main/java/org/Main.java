package main.java.org;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("D:\\output.txt");
        names.add("D:\\input.txt");
        names.add("D:\\in.json");
        names.add("D:\\input.xml");
        names.add("D:\\output.json");
        names.add("D:\\output.xml");
        ZipDearch cra = new ZipDearch("D:\\output.zip");
        ArrayList<String> a;
        a = cra.DeArchvize();
        for (int i = 0 ; i < a.size(); i++)
            System.out.println(a.get(i));
    }
}