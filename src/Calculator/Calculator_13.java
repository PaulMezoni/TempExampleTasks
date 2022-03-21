package Calculator;

import java.util.Scanner;

public class Calculator_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Введите выражение.
                Для ввода необходимо использовать два натуральных числа от 1 до 10 включительно и знак операции (+,-,*,/) между ними.
                Допускается использовать как арабские, так и римские цифры.
                Не допускается использовать арабкские и римские цифры вместе.""");

        while (true) {
            String expression = sc.nextLine();
            String[] values = expression.replaceAll("\\s", "").split("[+-/*]", 2);
            String operand = expression.replaceAll("[\\w\\s]", "");

            if (values.length != 2)
                System.out.println("Введенные данные не соответствуют заданным условиям.");
            else {
                int[] value1 = conversion(values[0]);
                int[] value2 = conversion(values[1]);
                if (value1[0] == 0 | value2[0] == 0 | value1[1] != value2[1])
                    System.out.println("Введенные данные не соответствуют заданным условиям.");
                else {
                    int result = operation(value1[0], value2[0], operand);
                    if (result < 0)
                        System.out.println("Натуральное число не может быть отрицательным.");
                    if (value1[1] == 0 | result == 0)
                        System.out.println(result);
                    else
                        reverseConversion(result);
                }
            }
        }
    }

    public static int[] conversion(String val) {
        if ("1".equals(val)) {
            return new int[]{1, 0};
        } else if ("2".equals(val)) {
            return new int[]{2, 0};
        } else if ("3".equals(val)) {
            return new int[]{3, 0};
        } else if ("4".equals(val)) {
            return new int[]{4, 0};
        } else if ("5".equals(val)) {
            return new int[]{5, 0};
        } else if ("6".equals(val)) {
            return new int[]{6, 0};
        } else if ("7".equals(val)) {
            return new int[]{7, 0};
        } else if ("8".equals(val)) {
            return new int[]{8, 0};
        } else if ("9".equals(val)) {
            return new int[]{9, 0};
        } else if ("10".equals(val)) {
            return new int[]{10, 0};
        } else if ("I".equals(val)) {
            return new int[]{1, 1};
        } else if ("II".equals(val)) {
            return new int[]{2, 1};
        } else if ("III".equals(val)) {
            return new int[]{3, 1};
        } else if ("IV".equals(val)) {
            return new int[]{4, 1};
        } else if ("V".equals(val)) {
            return new int[]{5, 1};
        } else if ("VI".equals(val)) {
            return new int[]{6, 1};
        } else if ("VII".equals(val)) {
            return new int[]{7, 1};
        } else if ("VIII".equals(val)) {
            return new int[]{8, 1};
        } else if ("IX".equals(val)) {
            return new int[]{9, 1};
        } else if ("X".equals(val)) {
            return new int[]{10, 1};
        }
        return new int[]{0, 0};
    }

    public static int operation(int val1, int val2, String operation) {
        if ("+".equals(operation)) {
            return val1 + val2;
        } else if ("-".equals(operation)) {
            return val1 - val2;
        } else if ("*".equals(operation)) {
            return val1 * val2;
        }
        return val1 / val2;
    }

    public static void reverseConversion(int res) {

        StringBuilder rome = new StringBuilder();
        if (res >= 90 && res < 100) {
            rome.append("XC");
            res -= 90;
            rome.append(rome10(res));
        } else if (res >= 50 && res < 90) {
            rome.append("L");
            res -= 50;
            rome = new StringBuilder(rome + "X".repeat(res / 10));
            rome.append(rome10(res % 10));
        } else if (res >= 40 && res < 50) {
            rome.append("XL");
            res -= 40;
            rome.append(rome10(res));
        } else if (res < 40) {
            rome.append("X".repeat(Math.max(0, res / 10)));
            rome.append(rome10(res % 10));
        } else if (res == 100)
            rome.append("C");
        System.out.println(rome);
    }

    public static String rome10(int res) {
        StringBuilder rome10 = new StringBuilder();
        if (res > 0 && res < 3)
            rome10.append("I".repeat(res));
        if (res == 4)
            rome10.append("IV");
        if (res >= 5 && res < 9) {
            rome10.append("V");
            res -= 5;
            if (res > 0 && res < 3)
                rome10.append("I".repeat(res));
        }
        if (res == 9)
            rome10.append("IX");
        return rome10.toString();
    }
}
