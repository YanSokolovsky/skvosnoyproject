package main.java.org;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class CalcWithLib {
    int res;
    String input;
    public Integer Calculate(String a) {
        input = a;
        DellSpaces();
        DoubleEvaluator eval = new DoubleEvaluator();
        Double result = eval.evaluate(input);
        Integer res = result.intValue();
        return res;
    }
    public String DellSpaces() {
        StringBuilder build = new StringBuilder(input);
        for (int i = 0 ; i < build.length(); i++) {
            if (build.charAt(i) == ' ') {
                build.deleteCharAt(i);
                i--;
            }
        }
        input = build.toString();
        return input;
    }
}
