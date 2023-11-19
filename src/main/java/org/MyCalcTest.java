package main.java.org;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class MyCalcTest {

    @org.junit.jupiter.api.Test
    void getPriority() {
    }

    @org.junit.jupiter.api.Test
    void dellSpaces() {
        String a = " ffffff f f f    3      4   f  g  g  h  ";
        MyCalc p = new MyCalc();
        p.input = a;
        p.DellSpaces();
        assertTrue(p.input.equals("fffffffff34fggh"));
    }

    @org.junit.jupiter.api.Test
    void calculating() {
    }

    @org.junit.jupiter.api.Test
    void getResult() {
    }
}