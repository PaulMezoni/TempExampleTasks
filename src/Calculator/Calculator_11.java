package Calculator;

import java.util.Scanner;

public class Calculator_11 {
    //блок массивов арабских и римских цифр
    static String[] romeNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] arabNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public static void main(String[] args) {
        System.out.println("Введите математическое выражение из двух натуральных чисел " +
                "от 1 до 10 и знака операции (+,-,*,/) между ними. " +
                "Пример: арабские - 1+1 или римские - I*I и нажмите Enter.");

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();


    }
}
