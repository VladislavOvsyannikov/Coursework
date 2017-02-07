package main;

public class Main{

    /*  ��������� �������������� ��������  */
    private static final String OPERATORS = "+-*/^";

    public static void main(String args[]){

        String source = "100^(1/2) + 2^2*5";
        System.out.println("�������� ��������� (��������� �������):  " + source);

        Postfix postfix = new Postfix(source, OPERATORS);
        String OPN = postfix.inPostfix();
        System.out.println("����������� �������:  " + OPN);

        Calculation calc = new Calculation(OPN, OPERATORS);
        double result = calc.value();
        if (result == (int)result)  System.out.println("��������� ���������� � ����������� �������:  " + (int)result);
        else System.out.println("��������� ���������� � ����������� �������:  " + result);
    }
}