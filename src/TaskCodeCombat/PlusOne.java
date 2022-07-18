package TaskCodeCombat;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {

        int[] x0 = {1}, x1 = {2}, x2 = {1, 0}, x3 = {1, 0, 0}, x4 = {1, 0, 1};
        System.out.println(Arrays.toString(x0) + " " + Arrays.equals(x0, plusOne(new int[]{0})) + " " + (Arrays.toString(plusOne(new int[]{0}))));
        System.out.println(Arrays.toString(x1) + " " + Arrays.equals(x1, plusOne(new int[]{1})) + " " + (Arrays.toString(plusOne(new int[]{1}))));
        System.out.println(Arrays.toString(x2) + " " + Arrays.equals(x2, plusOne(new int[]{9})) + " " + (Arrays.toString(plusOne(new int[]{9}))));
        System.out.println(Arrays.toString(x3) + " " + Arrays.equals(x3, plusOne(new int[]{9, 9})) + " " + (Arrays.toString(plusOne(new int[]{9, 9}))));
        System.out.println(Arrays.toString(x4) + " " + Arrays.equals(x4, plusOne(new int[]{1, 0, 0})) + " " + (Arrays.toString(plusOne(new int[]{1, 0, 0}))));
        System.out.println();
        System.out.println(Arrays.toString(x3) + " " + Arrays.equals(x3, plusOne2(new int[]{9, 9})) + " " + (Arrays.toString(plusOne2(new int[]{9, 9}))));
        System.out.println(Arrays.toString(x2) + " " + Arrays.equals(x2, plusOne2(new int[]{9})) + " " + (Arrays.toString(plusOne2(new int[]{9}))));
        System.out.println(Arrays.toString(x0) + " " + Arrays.equals(x0, plusOne2(new int[]{0})) + " " + (Arrays.toString(plusOne2(new int[]{0}))));


    }

    public static int[] plusOne2(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        int i = Integer.parseInt(String.valueOf(sb));
        int i2 = i + 1;
        String s = String.valueOf(i2);
        char[] c = s.toCharArray();
        for (int j = 0; j < s.length(); j++) {
            if (digits.length < c.length) {
                digits = new int[c.length];
            }
            digits[j] += Character.digit(c[j], 10);
        }
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for (int j = digits.length - 1; j >= 0; j--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                i--;
                if (i < 0) {
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                    break;
                }
            }
        }
        if (i >= 0) {
            digits[i]++;
        }
        return digits;
    }
}
