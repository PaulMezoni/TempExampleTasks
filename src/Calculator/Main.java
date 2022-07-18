package Calculator;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        DataCalculator data = new DataCalculator();
        System.out.println("Введите математическое выражение из двух натуральных чисел" +
                " от 1 до 10 и знака операции (+,-,*,/) между ними.\\n" +
                "Пример: 1*10 - арабские или римские - I*X.\n");

        while (true) {
            try {

                data.read();

            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
//                break;
            }
        }
    }
}

class DataCalculator {

    private int x;
    private int y;
    private char operation;

    public void read() {
        String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        Scanner scanner = new Scanner(System.in); // объявляем класс сканер
        String expression = scanner.nextLine(); // сканер считывает строку

        try {
            String[] blocks = expression.split("[+-/*]");

            // проверяем, входит ли строка blocks[0] в массив строк массива "roman"
            boolean flag = false;

            for (String s : roman) {    // начало цикла for
                if (s.equals(blocks[0]) || s.equals(blocks[1])) {
                    flag = true;
                    break;
                }
            }               // завершилось условие, но итерация продолжается

            if (flag) {
                x = RomanToArab.romanToArab((blocks[0].trim()));
                y = RomanToArab.romanToArab((blocks[1].trim()));
            } else {        // здесь завершается 2 условие и начинается 3, но цикл идёт дальше
                x = Integer.parseInt(blocks[0].trim());
                y = Integer.parseInt(blocks[1].trim());
            }               // кончилось 3 условие
            operation = expression.charAt(blocks[0].length());

            int result = Calculator.calculate(getVar1(), getVar2(), getOper());
            // исключения и ошибки
//            if (result <= 0 || result > 10) {
//                throw new IllegalArgumentException();
//            }

            if ((x > 10 || x < 1) && (y > 10 || y < 1)) {
                throw new IllegalArgumentException("<<  Неверный формат данных  >>");
            }
            if (!flag) {
                System.out.println(result); // арабский
            }
            if (flag) {
                System.out.println(ArabToRoman.toRoman(result)); // римский
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("<<  Неверный формат данных   >>");
        } finally {
            System.out.print("");
        }
        System.out.print("");
    }

    public int getVar1() {
        return x;
    }

    public int getVar2() {
        return y;
    }

    public char getOper() {
        return operation;
    }
}

class Calculator {

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

class RomanToArab {

    private static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public static int romanToArab(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }
        return res;
    }
}

//арабские в римские
class ArabToRoman {

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String toRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }
}


