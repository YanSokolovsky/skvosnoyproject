package main.java.org;

import java.util.ArrayList;
import java.util.Stack;

public class MyCalc {
    public static class ob {
        Integer operand;
        char sign;
        boolean type;
        public ob(int a) {
            operand = a;
            sign = ' ';
            type = true;
        }
        public ob(char a) {
            operand = Integer.MIN_VALUE;
            sign = a;
            type = false;
        }
        public boolean IsOperand() {
                return type;
        }
    }

    String input;
    Integer result;
    ArrayList<ob> SimpleOrder;
    ArrayList<ob> PolandOrder;
    public int GetPriority(char a) {
        switch (a){
            case '-':
            case '+':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^': return 3;
            case ')': return 0;
            default: return -1;
        }
    }
    public void DellSpaces() {
        StringBuilder build = new StringBuilder(input);
        for (int i = 0 ; i < build.length(); i++) {
            if (build.charAt(i) == ' ') {
                build.deleteCharAt(i);
                i--;
            }
        }
        input = build.toString();
    }
    public static String DellSpacesForMain(String a) {
        String input = a;
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
    public void MakeSimpleOrder() {
        DellSpaces();
        SimpleOrder = new ArrayList<ob>();
        int timeless = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                while (i < input.length() && input.charAt(i) - '0' >= 0 && input.charAt(i) - '0' <= 9) {
                    timeless = timeless * 10 + (input.charAt(i) - '0');
                    i++;
                }
                i--;
                ob node = new ob(timeless);
                timeless = 0;
                SimpleOrder.add(node);
            } else {
                ob f = new ob(input.charAt(i));
                SimpleOrder.add(f);
            }
        }
    }
    public void MakePolandOrder() {
        PolandOrder = new ArrayList<ob>();
        Stack<ob> znaki = new Stack<ob>();
        for (int i = 0; i < SimpleOrder.size(); i++) {
            if (!SimpleOrder.get(i).IsOperand()) {
                if (SimpleOrder.get(i).sign == '(')
                {
                    ob f = new ob('(');
                    znaki.push(f);
                } else {
                    if (SimpleOrder.get(i).sign == ')') {
                        while(znaki.peek().sign != '(') {
                            ob f = znaki.pop();
                            PolandOrder.add(f);
                        }
                        znaki.pop();
                    } else {
                        while(!znaki.empty() && GetPriority(znaki.peek().sign) >= GetPriority(SimpleOrder.get(i).sign)) {
                            ob f = znaki.pop();
                            PolandOrder.add(f);
                        }
                        znaki.push(new ob(SimpleOrder.get(i).sign));
                    }
                }
            } else {
                PolandOrder.add(new ob(SimpleOrder.get(i).operand));
            }
        }
        while(!znaki.empty()) {
            ob f = znaki.pop();
            PolandOrder.add(f);
        }
    }
    public void Calculating() {
         Stack<ob> c = new Stack<ob>();
         for (int i = 0; i < PolandOrder.size(); i++) {
             if (!PolandOrder.get(i).IsOperand()) {
                 int a = c.pop().operand;
                 int b = c.pop().operand;
                 switch (PolandOrder.get(i).sign){
                     case '-':
                         c.push(new ob(b - a));
                         break;
                     case '+':
                         c.push(new ob(b + a));
                         break;
                     case '*':
                         c.push(new ob(b * a));
                         break;
                     case '/':
                         c.push(new ob(b / a));
                         break;
                     case '^':
                         c.push(new ob((int)Math.pow(b, a)));
                         break;
                     default: break;
                 }
             } else {
                 c.push(PolandOrder.get(i));
             }
         }
         result = c.pop().operand;
    }
    public int GetResult(String a) {
        input = a;
        MakeSimpleOrder();
        MakePolandOrder();
        Calculating();
        return result;
    }
}
