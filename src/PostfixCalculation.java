import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostfixCalculation {
    public static String calculate(String op1, String op2, String operation) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = op1 + operation + op2;
        return engine.eval(foo).toString();
    }

    public static boolean isNumeric(String str) {
        String regex = "[+-]?([0-9]*[.])?[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void main(String[] args) throws ScriptException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the expression (*separated by blank space): ");
        String expr = input.nextLine();
        Stack<String> stack = new Stack<>();
        String[] code = expr.split(" ");
        for (String s : code) {
            if (isNumeric(s)) {
                stack.push(s);
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(calculate(op1, op2, s));
            }
        }
        System.out.println("Result: " + stack.pop());
    }
}