package Java_Mentor;

public class Solution {


    public static void main(String[] args) {
//        int[][] a = {{5, 6, 7}, {1, 2, 3, 4}};
//        int[] b = {5, 6, 7};
//        System.out.println(Arrays.deepToString(a));
//        System.out.println(Arrays.toString(b));

//        System.out.println("A" + ('\t' + '\u0003') + "\n" +
//                ('A' + '1' + "2") + "\n" +
//                ("A" + 12) + "\n" + ('A' + "12"));

//        System.out.println(isPowerOfTwo3(0) + " 0");
//        System.out.println(isPowerOfTwo3(1) + " 1");
//        System.out.println(isPowerOfTwo3(-2) + " -2");
//
//        System.out.println(isPowerOfTwo(0) + " 0");
//        System.out.println(isPowerOfTwo(1) + " 1");
//        System.out.println(isPowerOfTwo(-2) + " -2");
//
//        System.out.println(0x0bp3); // type literal
//
//        System.out.println(doubleExpression(1, 1, 2.00005));
//        System.out.println(drawisMonitorsCounter(20, 9));

        System.out.println(isPalindrome("Was it a cat I saw?"));
        System.out.println(isPalindrome("A palindrome is a word, number, phrase, " +
                "or other sequence of characters which reads the same backward as forward, " +
                "such as madam or racecar or the number 10801."));
    }

    public static boolean isPowerOfTwo3(int value) {
        int a = 0;
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    public static boolean isPowerOfTwo(int value) {

        return Math.abs(value) == 1;
    }

    public static boolean doubleExpression(double a, double b, double c) {

        return Math.abs(a + b - c) < 1E-4;
    }

    public static int drawisMonitorsCounter(int monitors, int programmers) {
        return monitors % programmers;
    }

    public static boolean isPalindrome(String text) {
        //Твой код здесь
        String a = text.toLowerCase().replaceAll("[^a-z]", ""); // нижний регистр и удаление пробелов
        String b = new StringBuilder(a).reverse().toString(); // реверс
        return a.equals(b); // возврат и сравнение
    }
}