package main.java.org;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("D:\\1.txt");
        names.add("D:\\2.txt");
        names.add("D:\\3.txt");
        RarArch rar = new RarArch(names);
        rar.DeArchvize("D:\\checking2.rar");
    }
}