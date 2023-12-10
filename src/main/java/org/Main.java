package main.java.org;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("D:\\1.txt");
        names.add("D:\\2.txt");
        names.add("D:\\3.txt");
        Chifrator chif = new Chifrator("D:\\1.json", "D:\\2.json", "keyforcrypto1234");
        chif.chiferfile();
        DeChifrator some = new DeChifrator("D:\\2.json", "d:\\3.json", "keyforcrypto1234");
        some.dechiferfile();
    }
}