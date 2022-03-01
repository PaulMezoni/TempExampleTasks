package TaskCodeCombat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class twoSumEx {
    public static void main(String[] args) throws InterruptedException {
        var a = 6;
        int[] k = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(twoSumHashSet(k, a)) + " = " + a + " twoSumHashSet");
        System.out.println(Arrays.toString(twoSumTwoPoint(k, a)) + " = " + a + " twoSumTwoPoint");
        System.out.println(Arrays.toString(twoSumTwoFor(k, a)) + " = " + a + " twoSumTwoFor");


    }

    // speed: O(n) memory: O(n)
    static int[] twoSumHashSet(int[] a, int k) {
        Set<Integer> set = new HashSet<>();
        for (int j : a) {
            var numberToFind = k - j;
            if (set.contains(numberToFind)) {
                return new int[]{j, numberToFind};
            } else {
                set.add(j);
            }
        }
        return new int[0];
    }

    // speed: O(n2) memory: O(1)
    static int[] twoSumTwoFor(int[] a, int k) {
        for (int value : a) {
            for (var j = 1; j < a.length; j++) {
                if (k == value + a[j]) {
                    return new int[]{value, a[j]};
                }
            }
        }
        return new int[0];
    }

    // speed: O(n) memory: O(1)
    static int[] twoSumTwoPoint(int[] a, int k) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            var sum = a[l] + a[r];
            if (sum == k) {
                return new int[]{a[l], a[r]};
            }
            if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return new int[0];
    }

}





