package main;

import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {

    private String OPERATORS;
    private Stack<String> stackOperations = new Stack<>();
    private Stack<String> stackPostfix = new Stack<>();
    private String source;

    public Postfix(String source, String OPERATORS){
        this.source=source;
        this.OPERATORS = OPERATORS;
    }

    public String inPostfix(){

        /** Убираем пробелы в исходном выражении и устраняем проблему со знаком минус:
         *  минус может выступать не только как бинарный оператор,
         *  но и как унарный — для записи отрицательных чисел  */
        source = source.replace(" ", "").replace("(-", "(0-");
        if (source.charAt(0) == '-') source = "0" + source;

        /*  Разделяем выражение на символы  */
        StringTokenizer tokens = new StringTokenizer(source, OPERATORS+"()", true);

        /*  Применяем алгоритм сортировочной станции  */
        while (tokens.hasMoreTokens()){
            String token = tokens.nextToken();
            if (isDigit(token)) {
                stackPostfix.push(token);
                stackPostfix.push(" ");
            }
            if (token.equals("(")){
                stackOperations.push(token);
            }
            if (token.equals(")")){
                while(!stackOperations.peek().equals("(")){
                    stackPostfix.push(stackOperations.pop());
                    stackPostfix.push(" ");
                }
                stackOperations.pop();
            }
            if (OPERATORS.contains(token)){
                while (!stackOperations.isEmpty()&&rank(stackOperations.peek())>=rank(token)) {
                    stackPostfix.push(stackOperations.pop());
                    stackPostfix.push(" ");
                }
                stackOperations.push(token);
            }
        }
        while(!stackOperations.isEmpty()) {
            stackPostfix.push(stackOperations.pop());
            stackPostfix.push(" ");
        }

        String str="";
        while (!stackPostfix.isEmpty()){
            str = stackPostfix.pop()+str;
        }
        return str;
    }

    private boolean isDigit(String token){
        if (!token.equals("(")&&!token.equals(")")&&!OPERATORS.contains(token)) return true;
        return false;
    }

    /*  Определяем приоритет арифмитической операции  */
    private static int rank(String token) {
        switch (token) {
            case "^":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
        }
        return 0;
    }
}
