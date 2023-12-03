package main.java.org;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCalc {
    String RegForBraces = "\\([^\\(\\)]*\\)";
    String RegForMulti = "\\d+\\.\\d+\\*\\d+\\.\\d+|\\d+\\.\\d+\\*\\d+|\\d+\\*\\d+\\.\\d+|\\d+\\*\\d+";
    String RegForSum = "\\d+\\.\\d+\\+\\d+\\.\\d+|\\d+\\.\\d+\\+\\d+|\\d+\\+\\d+\\.\\d+|\\d+\\+\\d+";
    String RegForSub = "\\d+\\.\\d+\\-\\d+\\.\\d+|\\d+\\.\\d+\\-\\d+|\\d+\\-\\d+\\.\\d+|\\d+\\-\\d+";
    String RegForDiv = "\\d+\\.\\d+\\/\\d+\\.\\d+|\\d+\\.\\d+\\/\\d+|\\d+\\/\\d+\\.\\d+|\\d+\\/\\d+";
    String RegForPow = "\\d+\\.\\d+\\^\\d+\\.\\d+|\\d+\\.\\d+\\^\\d+|\\d+\\^\\d+\\.\\d+|\\d+\\^\\d+";
    private static String DellSpaces(String a) {
        String input = a;
        StringBuilder build = new StringBuilder(input);
        for (int i = 0 ; i < build.length(); i++) {
            if (build.charAt(i) == ' ' || build.charAt(i) == '\r') {
                build.deleteCharAt(i);
                i--;
            }
        }
        input = build.toString();
        return input;
    }
    private boolean checkForBraces(String a) {
        boolean res = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ')' || a.charAt(i) == '(')
                res = true;
        }
        return res;
    }
    private String RemovePow(String a) {
        Pattern pat = Pattern.compile(RegForPow);
        StringBuilder in = new StringBuilder(a);
        Matcher match = pat.matcher(in);
        String result = a;
        while(match.find()) {
            int start = match.start();
            int end = match.end();
            String ex = result.substring(start, end);
            String res = CalcAtomEx(ex);
            result = match.replaceFirst(res);
            match = pat.matcher(result);
        }
        return result;
    }
    private String RemoveDiv(String a) {
        Pattern pat = Pattern.compile(RegForDiv);
        StringBuilder in = new StringBuilder(a);
        Matcher match = pat.matcher(in);
        String result = a;
        while(match.find()) {
            int start = match.start();
            int end = match.end();
            String ex = result.substring(start, end);
            String res = CalcAtomEx(ex);
            result = match.replaceFirst(res);
            match = pat.matcher(result);
        }
        return result;
    }
    private String RemoveMulti(String a) {
        Pattern pat = Pattern.compile(RegForMulti);
        StringBuilder in = new StringBuilder(a);
        Matcher match = pat.matcher(in);
        String result = a;
        while(match.find()) {
            int start = match.start();
            int end = match.end();
            String ex = result.substring(start, end);
            String res = CalcAtomEx(ex);
            result = match.replaceFirst(res);
            match = pat.matcher(result);
        }
        return result;
    }
    private String RemoveSum(String a) {
        Pattern pat = Pattern.compile(RegForSum);
        StringBuilder in = new StringBuilder(a);
        Matcher match = pat.matcher(in);
        String result = a;
        while(match.find()) {
            int start = match.start();
            int end = match.end();
            String ex = result.substring(start, end);
            String res = CalcAtomEx(ex);
            result = match.replaceFirst(res);
            match = pat.matcher(result);
        }
        return result;
    }
    private String RemoveSub(String a) {
        Pattern pat = Pattern.compile(RegForSub);
        StringBuilder in = new StringBuilder(a);
        Matcher match = pat.matcher(in);
        String result = a;
        while(match.find()) {
            int start = match.start();
            int end = match.end();
            String ex = result.substring(start, end);
            String res = CalcAtomEx(ex);
            result = match.replaceFirst(res);
            match = pat.matcher(result);
        }
        return result;
    }
    private String CalcExWithoutBrace1(String a) {
        StringBuilder input = new StringBuilder(a);
        input.deleteCharAt(0);
        input.deleteCharAt(input.length() - 1);
        String res = RemovePow(input.toString());
        res = RemoveMulti(res);
        res = RemoveDiv(res);
        res = RemoveSum(res);
        res = RemoveSub(res);
        return res;
    }
    private String CalcExWithoutBrace2(String a) {
        a = DellSpaces(a);
        String res = RemovePow(a);
        res = RemoveMulti(res);
        res = RemoveDiv(res);
        res = RemoveSum(res);
        res = RemoveSub(res);
        return res;
    }
    public Double Calculating(String exp) {
        exp = DellSpaces(exp);
        Pattern pat = Pattern.compile(RegForBraces);
        Matcher mat = pat.matcher(exp);
        String result = exp;
        if (checkForBraces(exp)) {
            while(mat.find()) {
                int start = mat.start();
                int end = mat.end();
                String ex = result.substring(start, end);
                String res = CalcExWithoutBrace1(ex);
                result = mat.replaceFirst(res);
                mat = pat.matcher(result);
            }
            result = CalcExWithoutBrace2(result);
        }
        else {
            result = CalcExWithoutBrace2(exp);
        }
        return Double.parseDouble(result);
    }
    private String CalcForAtomEx(Double a, Double b, char sign) {
        Double res = 0.0;
        switch (sign){
            case '-':
                res = a - b;
                break;
            case '+':
                res = a + b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                if (b == 0.0) {
                    System.out.println("division by 0. Please, try to find mistake in expression.");
                    res = Double.MAX_VALUE;
                    return res.toString();
                } else {
                    res = a / b;
                }
                break;
            case '^':
                if (a < 0) {
                    System.out.println("powering negative value. It is imposible for some cases.");
                    res = Double.MIN_VALUE;
                    return res.toString();
                } else {
                    res = Math.pow(a, b);
                }
                break;
            default:
                System.out.println("Invalid operation. Result will be equal to 0. Please find mistake in expression.");
                return res.toString();
        }
        return res.toString();
    }
    private String CalcAtomEx(String input) {
        Double operand1 = 0.0;
        Double operand2 = 0.0;
        int flag = 0;
        int counter = 0;
        int i = 0;
        while (i < input.length() && (input.charAt(i) - '0' >= 0 && input.charAt(i) - '0' <= 9 || input.charAt(i) == '.')) {
            if (flag == 1) {
                counter++;
            }
            if (input.charAt(i) != '.') {
                operand1 = operand1 * 10.0 + (double) (input.charAt(i) - '0');
            } else {
                flag = 1;
            }
            i++;
        }
        for (int y = 0 ; y < counter; y++) {
            operand1 = operand1 / 10.0;
        }
        char sign = input.charAt(i);
        flag = 0;
        counter = 0;
        i++;
        while (i < input.length() && (input.charAt(i) - '0' >= 0 && input.charAt(i) - '0' <= 9 || input.charAt(i) == '.')) {
            if (flag == 1) {
                counter++;
            }
            if (input.charAt(i) != '.') {
                operand2 = operand2 * 10.0 + (double) (input.charAt(i) - '0');
            } else {
                flag = 1;
            }
            i++;
        }
        for (int y = 0 ; y < counter; y++) {
            operand2 = operand2 / 10.0;
        }
        return CalcForAtomEx(operand1, operand2, sign);
    }
}
