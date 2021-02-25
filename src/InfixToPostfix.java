import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    public static int prec(String c) {
        if (c.equals("*") || c.equals("/") || c.equals("%")) {
            return 2;
        } else if (c.equals("+") || c.equals("-")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean isOperand(String str) {
        String regex = "[+-]?([0-9]*[.])?[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner input = new Scanner(System.in);
        String expr = input.nextLine();
        String[] code = expr.split(" ");
        for (String s : code) {
            if (isOperand(s)) {
                System.out.print(s + " ");
            } else {
                if (stack.isEmpty() || s.equals("(") || prec(s) > prec(stack.peek())) {
                    stack.push(s);
                } else if (s.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        System.out.print(stack.pop() + " ");
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && prec(s) <= prec(stack.peek())) {
                        System.out.print(stack.pop() + " ");
                    }
                    stack.push(s);
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
    }
}
