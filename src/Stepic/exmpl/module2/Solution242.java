package Stepic.exmpl.module2;

import java.util.Arrays;

public class Solution242 {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8};
        int[] b = {3, 5, 1, 7, 9};
        System.out.println(Arrays.toString(mergeArrays(a, b)));
        System.out.println(Arrays.toString(mergeArrays1(a, b)));
        System.out.println(Arrays.toString(mergeArrays2(a, b)));

    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     */
    public static int[] mergeArrays2(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        int pos1 = 0;
        int pos2 = 0;
        while (pos1 < a1.length || pos2 < a2.length) {
            a3[pos1 + pos2] = (pos1 < a1.length && (pos2 == a2.length || a1[pos1] < a2[pos2]) ?
                    a1[pos1++] : a2[pos2++]);
        }
        return a3;
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
//        while (a1.length+ a2.length){
//        }
        return a3;
    }

    public static int[] mergeArrays1(int[] a1, int[] a2) {

        int[] a3 = new int[a1.length + a2.length];
        int temporary = 0;

        for (int i = 0; i < a1.length; i++) {
            a3[i] = a1[i];
            temporary++;
        }
        for (int j : a2) {
            a3[temporary++] = j;
        }
        for (int l = 0; l < a3.length; l++) {
            for (int m = 0; m < a3.length; m++) {
                if (a3[l] < a3[m]) {
                    int temp = a3[l];
                    a3[l] = a3[m];
                    a3[m] = temp;
                }
            }
        }
        return a3;
    }
}
