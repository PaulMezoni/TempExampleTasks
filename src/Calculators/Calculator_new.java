package Calculators;

import java.util.Scanner;

public class Calculator_new {
    static int x;
    static int y;
    static char operation;
    static String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {

        System.out.println("Введите математическое выражение из двух натуральных чисел" +
                " от 1 до 10 и знака операции (+,-,*,/) между ними.\n" +
                "Пример: 1*10 - арабские или римские - I*X. ");

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String expression = scanner.nextLine();

                String[] blocks = expression.split("[+-/*]");

                boolean flag = false;
                for (String s : roman) {
                    if (s.equals(blocks[0].trim()) || s.equals(blocks[1].trim())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    x = romanToArabic(blocks[0]);
                    y = romanToArabic(blocks[1]);
                } else {
                    x = Integer.parseInt(blocks[0].trim());
                    y = Integer.parseInt(blocks[1].trim());
                }
                operation = expression.charAt(blocks[0].length());
                int result = calculate(x, y, operation);
                if (result <= 0 || result > 10) {
                    System.err.println(" результат не должен быть меньше 0 и не больше 10 ");
                    continue;
                }
                if (!flag) {
                    System.out.println(result); // арабский
                }
                if (flag) {
                    System.out.println(arabicToRoman(result)); // римский
                }
            } catch (RuntimeException runtimeException) {
                String message = runtimeException.getMessage();
                System.err.println(message);
            }
        }
    }

    public static CharSequence arabicToRoman(int num) {
        if (num <= 0) return "";
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num != 0; i++) {
            while (num >= n[i]) {
                num -= n[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    public static int romanToArabic(String s) {
        char[] sc = s.toCharArray();
        int sum = 0;
        for (int index = sc.length - 1; index >= 0; index--) {
            if (sc[index] == 'I') {
                sum += (sum < 5 ? 1 : -1);
            } else if (sc[index] == 'V') {
                sum += 5;
            } else if (sc[index] == 'X') {
                sum += (sum < 50 ? 10 : -10);
            }
        }
        return sum;
    }

    public static int calculate(int number1, int number2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("<<   Неверный знак операции   >>");
        }
        return result;
    }
}
