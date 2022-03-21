package TaskCodeCombat;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        StringBuilder sb = new StringBuilder();
        for (int i : digits) {
            sb.append(i);
        }
        int integers = Integer.parseInt(String.valueOf(sb)) + 1;
        String s = String.valueOf(integers);
        char[] ch = s.toCharArray();
//        System.out.println(Arrays.toString(ch));
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
                i--;
            }
        }
        int[] Newdigits = new int[digits.length + 1]; // all elements are 0
        Newdigits[0] = 1;
        return Newdigits;
    }


    public static void main(String[] args) {
        int[] digits = {2, 2, 4};
        int[] digits2 = {9};

//        System.out.println(Arrays.toString(plusOne(digits)));
//        System.out.println(Arrays.toString(plusOne(digits2)));
//        System.out.println(Arrays.toString(plusOne2(digits)));
        System.out.println(Arrays.toString(plusOne2(digits2)));
    }
}
