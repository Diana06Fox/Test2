package P1;

import java.io.IOException;
import java.util.Scanner;

public class Calc {
    public static String Calc(String input) {
        char znak_operacii = ' ';
        String a1;
        String a2;
        String result = null;

        int n1;
        int n2;

        try {
            INNER:
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                    znak_operacii = input.charAt(i);
                    break INNER;
                }
            }
            if (znak_operacii == ' ') {
                throw new RuntimeException();
            }

            a1 = input.substring(0, input.indexOf(znak_operacii));    //нашли первое число, до знака операции
            a2 = input.substring(input.indexOf(znak_operacii) + 1, input.length());//второе число
            n1 = Integer.parseInt(a1.trim());
            n2 = Integer.parseInt(a2.trim());
            if (n1>0 && n1 < 11 && n2>0 && n2 < 11) {
                switch (znak_operacii) {
                    case '+':
                        result =String.valueOf(n2+" "+(n1 + n2));
                        break;
                    case '-':
                        result = String.valueOf(n1 - n2);
                        break;
                    case '*':
                        result = String.valueOf(n1 * n2);
                        break;
                    case '/':
                        result = String.valueOf(n1 / n2);
                        break;
                }
            }
            else {
                throw new IOException();}

        }

        catch (RuntimeException e) {
            result = "Введенная строка, не соответствует одной из вышеописанных арифметических операций";}
        catch (IOException e){
            result="Введеный пример не соответствует условиям введения чисел в диапозоне от 1 до 10";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Введите выражение по примеру: a + b; a - b; a * b; a / b");
        Scanner scan=new Scanner(System.in);
        String s= scan.nextLine();
        System.out.println( "результат математического выражения: "+ Calc(s));

    }
}

