package Stepic.exmpl.module2;

public class Solution411 {
    public static void main(String[] args) {

        System.out.println(sqrt(0));
        System.out.println(sqrt(4));
        System.out.println(sqrt(46));
        System.out.println(sqrt(-2));
    }

    public static double sqrt(double x) throws IllegalArgumentException {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }
}
