package TaskCodeCombat;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        int[] y = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] += x[x.length - 1 - i];
        }
        System.out.println(Arrays.toString(y));

    }
}
