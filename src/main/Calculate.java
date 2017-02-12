package main;

import java.util.Stack;

public class Calculate {

    private String OPERATORS;
    private String str;
    private Stack<String> stack = new Stack<>();

    public Calculate(String str, String OPERATORS){
        this.str=str;
        this.OPERATORS=OPERATORS;
    }

    /*  Вычисляем выражение в обратной польской нотации, используя стек  */
    public double value(){
        String[] arr = str.split(" ");
        for (int i=0; i<arr.length; i++){
            if (isDigit(arr[i])){
                stack.push(arr[i]);
            }else{
                Double a = new Double(stack.pop());
                Double b = new Double(stack.pop());
                Double c = s(arr[i],b,a);
                stack.push(Double.toString(c));
            }
        }
        return new Double(stack.pop());
    }

    private boolean isDigit(String token){
        if (!OPERATORS.contains(token)) return true;
        return false;
    }

    private double s(String str, double b, double a){
        switch (str) {
            case "^" : return Math.pow(b,a);
            case "*" : return b*a;
            case "/" : return b/a;
            case "+" : return b+a;
            case "-" : return b-a;
        }
        return 0;
    }
}
