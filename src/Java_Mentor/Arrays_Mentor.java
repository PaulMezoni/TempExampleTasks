package Java_Mentor;

import java.math.BigInteger;
import java.util.Arrays;

import static java.util.Arrays.sort;

public class Arrays_Mentor {

    public static void main(String[] args) {

        counter(3);

        int[] arr = {3, 5, 20, 8, 7, 3, 100};
        String[] strings = {"Tom", "Adam", "Cat", "Bob", "Dilan"};
//        printOddNumbers(arr);

        // переполнение  = -294_967_296
        int i = 2000000000;
//        System.out.println(i + i);

        float y = 1.123456789012345678901234567890F; // 7 знаков после ,
        double q = 1.123456789012345678901234567890D; // 16 знаков после ,
//        System.out.println(y);
//        System.out.println(q);

        short x = (short) 32762;
        char symbol = (char) x;
//        System.out.println(symbol+" jao");

        char xx = 32768;
        short sym = (short) xx;
//        System.out.println(sym);

        byte a = 1;
        byte b = 2;
        byte c = (byte) (a + b);
//        System.out.println(c);


//        System.out.println(BigInteger.valueOf(2));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

//        double decimal = 300.14;
//        byte decimal1 = (byte) decimal;
//        System.out.println("double to byte " + decimal + " = " + decimal1);
//
//        int num1 = 152;
//        String nir = Integer.toBinaryString(num1);
//        System.out.println("перевод в двоичную систему " + num1 + " = " + nir);
//        System.out.println(factorial(6));
//        System.out.println(factorial1(6));

        int[] a1 = {0, 2, 2};
        int[] a2 = {1, 3};
//        System.out.println(Arrays.toString(mergeArrays(a1, a2)));

        // роли Ревизора
        String[] roles = new String[]{
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"
        };

        String[] textLines = new String[]{
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
        System.out.println(printTextPerRole(roles, textLines));

    }

    static void counter(int n) {
        if (n == 0) { // условие выхода
            return;
        }
//        System.out.println(n);
        counter(n - 1); // шаг
    }

    // 2.2.8
    public static boolean isPowerOfTwo(int value) {
        //Твой код здесь
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    // 2.3.10
    public static boolean isPalindrome(String text) {
        //Твой код здесь
        String a = text.toLowerCase().replaceAll("[^a-z]", ""); // нижний регистр и удаление пробелов
        String b = new StringBuilder(a).reverse().toString(); // реверс
        return a.equals(b); // возврат и сравнение
    }

    //2.4.13
    // без рекурсии
    public static BigInteger factorial(int value) {
//Твой код здесь
        BigInteger fac = BigInteger.ONE;

        for (int i = 1; i <= value; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }

    //2.4.14
    // вычисление факториала через BigInteger с рекурсией
    public static BigInteger factorial1(int value) {
//Твой код здесь
        if (value <= 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(value).multiply(factorial1(value - 1));
        }
    }

    // 2.4.15
    public int determineGroup(int age) {
        //Твой код здесь
        if (7 <= age && age <= 13) {
            return 1;
        }
        if (14 <= age && age <= 17) {
            return 2;
        }
        if (18 <= age && age <= 65) {
            return 3;
        }
        return -1;
    }

    // 2.4.16
    public static int[] evenArray(int number) {
        //Твой код здесь
        int[] result = new int[number / 2];
        for (int i = 0; i < result.length; i++) {
            if (result[i] % 2 == 0) {
                result[i] = (i + 1) * 2;
            }
        }
        return result;
    }

    // 2.4.17
//   Напишите метод printOddNumbers,
//    который принимает массив и выводит в консоль только нечетные числа из него, через запятую.
//    Конец вывода должен перевести курсор на новую строку.

    //            if ((i & 1) == 1)
    public static void printOddNumbers(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            if (i % 2 != 0) {
                sb.append(",").append(i);
            }
        }
        System.out.println(sb.substring(1));
    }

    // 2.4.18
    public static int[] mergeArrays(int[] a1, int[] a2) {
        //твой код здесь
        int[] result = new int[a1.length + a2.length];
        int idxOne = 0, idxTwo = 0;

        for (int i = 0; i < result.length; i++) {
            if (idxTwo >= a2.length || idxOne < a1.length && a1[idxOne] < a2[idxTwo]) {
                result[i] = a1[idxOne];
                idxOne++;
            } else {
                result[i] = a2[idxTwo];
                idxTwo++;
            }
        }
        return result;
    }

    // 2.4.19
    //Напишите метод, который будет группировать строчки по ролям,
    // пронумеровывать их и возвращать результат в виде готового текста (см. пример).
    // Каждая группа распечатывается в следующем виде:
    public static String printTextPerRole(String[] roles, String[] textLines) {
        //Твой код здесь
        StringBuilder sb = new StringBuilder();
        for (String r : roles) {
            sb.append(r).append(":\n");

            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(r + ":")) {
                    sb.append(i + 1).append(") ").append(textLines[i].substring(r.length() + 1)).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    // Bubble Sort
    public static void isSortedBuble(int[] mas) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }

    public static void quickSort(int[] mas) {
        sort(mas);
        System.out.println(Arrays.toString(mas));
    }

    // quick sort algorithm
    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {

// Двигаем левый маркер слева направо пока элемент меньше, чем pivot

            while (source[leftMarker] < pivot) {
                leftMarker++;
            }

// Двигаем правый маркер, пока элемент больше, чем pivot

            while (source[rightMarker] > pivot) {
                rightMarker--;
            }

// Проверим, не нужно обменять местами элементы, на которые указывают маркеры

            if (leftMarker <= rightMarker) {

// Левый маркер будет меньше правого только если мы должны выполнить swap

                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }

// Сдвигаем маркеры, чтобы получить новые границы

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);


// Выполняем рекурсивно для частей

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
}






