package Calculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Calculator_14 {

    //вход в программу
    public static void main(String[] args) {

        Reader reader = new Reader();
        reader.read();
    }

    public static class Reader {
        //блок массивов арабских и римских цифр
        static String[] romeNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        static String[] arabNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        public void read() {
            //сканнер
            Scanner scanner = new Scanner(System.in);
            //инструкция
            System.out.print("""
                    Введите математическое выражение из двух натуральных чисел от 1 до 10 и знака операции (+,-,*,/) между ними.
                    Пример: 1+10 - арабские или римские - I+X.
                    """);

            while (true) {
                try {
                    boolean Flag = false;
                    System.out.print("");

                    String inputString = scanner.nextLine();

                    String string1 = num1(inputString.replaceAll("\\s+", ""));
                    String string2 = num2(inputString.replaceAll("\\s+", ""));

                    int X = 0;
                    int Y = 0;

                    if (Arrays.asList(romeNum).contains(string1) & Arrays.asList(romeNum).contains(string2)) {
                        X = romanToNumber(string1);
                        Y = romanToNumber(string2);
                    }
                    if (Arrays.asList(arabNum).contains(string1) & Arrays.asList(arabNum).contains(string2)) {
                        Flag = true;
                        X = Integer.parseInt(string1);
                        Y = Integer.parseInt(string2);
                    }
                    // блок операций и результата
                    int result = Calculator.calculate(X, Y, Operator.operator(inputString));

                    if (Flag) {
                        System.out.println(result);
                    }
                    if (!Flag) {
                        System.out.println(RomanNumerals.toRoman(result));
                    }

                    // блок ошибок и исключений
                    if (Flag && result <= 0) {
                        System.err.println("не может быть нолем или отридцательным числом");
                        break;
                    }
                    if ((X < 1 || X > 10) || (Y < 1 || Y > 10)) {
                        System.err.println("<< неверный формат данных >>");
                        break;
                    }
                } catch (ArithmeticException e) {
                    System.err.println("делить на ноль нельзя!");
                    break;
                } catch (RuntimeException e) {
                    System.err.println("<< неверный формат данных >>");
                    break;
                } finally {
                    System.out.print("");
                }
                System.out.print("");
            }
        }
    }

    //Калькулятор
    public static class Calculator {
        public static int calculate(int a, int b, int operation) {
            return switch (operation) {
                case 1 -> a + b;
                case 2 -> a - b;
                case 3 -> a * b;
                case 4 -> a / b;
                default -> throw new IllegalArgumentException("Неверный знак операции");
            };
        }
    }

    // математический оператор
    public static class Operator {

        public static int operator(String inputString) {

            if (inputString.indexOf('+') != -1) {
                return 1;
            } else if (inputString.indexOf('-') != -1) {
                return 2;
            } else if (inputString.indexOf('*') != -1) {
                return 3;
            } else if (inputString.indexOf('/') != -1) {
                return 4;
            } else {
                return -1;
            }
        }
    }

    //индекс оператора в строке для разбития строки на подстроки.
    public static int OperatorIndex(String inputString) {
        int index1 = inputString.indexOf('+');
        int index2 = inputString.indexOf('-');
        int index3 = inputString.indexOf('*');
        int index4 = inputString.indexOf('/');
        if (inputString.indexOf('+') != -1) {
            return index1;
        } else if (inputString.indexOf('-') != -1) {
            return index2;
        } else if (inputString.indexOf('*') != -1) {
            return index3;
        } else if (inputString.indexOf('/') != -1) {
            return index4;
        } else {
            return -1;
        }
    }

    //String 1 по оператору
    public static String num1(String inputString) {
        int index = OperatorIndex(inputString);
        return inputString.substring(0, index);
    }

    //String 2 по оператору
    public static String num2(String inputString) {
        String result;
        int index = OperatorIndex(inputString);
        if (OperatorIndex(inputString) != -1) {
            result = inputString.substring(index + 1);
            return result;
        } else {
            return "0";
        }
    }

    // римские в арабские
    private static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        return -1;
    }

    private static int romanToNumber(String str) {
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
                i++;
            }
        }
        return res;
    }

    //арабские в римские
    public static class RomanNumerals {
        private final static TreeMap<Integer, String> map = new TreeMap<>();

        static {
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
}


