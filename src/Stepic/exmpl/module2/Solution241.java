package Stepic.exmpl.module2;

import java.math.BigInteger;

public class Solution241 {
    public static void main(String[] args) {
        System.out.println(factorial(0));
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(50));
    }

    public static BigInteger factorial(int value) {
        BigInteger bigInteger = BigInteger.valueOf(value);
        if (value <= 1) {
            return BigInteger.valueOf(1);
        }
        return factorial(value - 1).multiply(bigInteger);
    }
}
