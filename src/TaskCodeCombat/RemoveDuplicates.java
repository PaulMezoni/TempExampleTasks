package TaskCodeCombat;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 2, 3, 4, 5, 5};
        int[] nums2 = {1, 2, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates(nums2));
        System.out.println(removeDuplicates2(nums));
        System.out.println(removeDuplicates2(nums2));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }

    static int removeDuplicates2(int[] nums) {
        return (int) Arrays.stream(nums).distinct().count();
    }
}
