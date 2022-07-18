package TaskCodeCombat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumEx {
    public static void main(String[] args) throws InterruptedException {
        var a = 6;
        int[] nums = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = List.of(1, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(Arrays.toString(twoSumHashSet(list, a)) + " = " + a + " twoSumHashSet");
        System.out.println(Arrays.toString(twoSumTwoPoint(nums, a)) + " = " + a + " twoSumTwoPoint");
        System.out.println(Arrays.toString(twoSumTwoFor(nums, a)) + " = " + a + " twoSumTwoFor");

    }

    // speed: O(n) memory: O(n)
    static int[] twoSumHashSet(List<Integer> a, int k) {
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
    static int[] twoSumTwoFor(int[] nums, int target) {
        for (int i : nums) {
            for (var j : nums) {
                if (target == i + j) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
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





