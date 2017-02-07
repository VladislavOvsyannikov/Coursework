package main;

public class Main{

    /*  Доступные арифмитические операции  */
    private static final String OPERATORS = "+-*/^";

    public static void main(String args[]){

        String source = "100^(1/2) + 2^2*5";
        System.out.println("Исходное выражение (инфиксная нотация):  " + source);

        Postfix postfix = new Postfix(source, OPERATORS);
        String OPN = postfix.inPostfix();
        System.out.println("Постфиксная нотация:  " + OPN);

        Calculation calc = new Calculation(OPN, OPERATORS);
        double result = calc.value();
        if (result == (int)result)  System.out.println("Результат вычисления в постфиксной нотации:  " + (int)result);
        else System.out.println("Результат вычисления в постфиксной нотации:  " + result);
    }
}