package Stepic.exmpl.module2;

public class Solution221 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2));
        System.out.println(isPowerOfTwo(-1));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount(Math.abs(value)) == 1; // you implementation here
    }
}
