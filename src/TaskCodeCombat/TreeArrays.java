package TaskCodeCombat;

import java.util.Arrays;

public class TreeArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5}, b = {3, 3, 4}, c = {2, 3, 4, 5, 6};
//        System.out.println(treeArrays(a, b, c));
//        System.out.println(intersection(a, b, c));
        intersection(a, b, c);
    }

    public static int intersection(int[] a, int[] b, int[] c) {
        return Arrays
                .stream(a)
                .filter(x -> Arrays.stream(b).anyMatch(y -> y == x))
                .filter(x -> Arrays.stream(c).anyMatch(y -> y == x))
                .findFirst().getAsInt();
    }


    static int treeArrays(int[] a, int[] b, int[] c) {
        int x = 0;
        for (int value : a) {
            for (int i : b) {
                if (value == i) {
                    x = value;
                    break;
                }
            }
        }
        for (int i : c) {
            if (i == x) {
                return x;
            }
        }
        return -1;
    }
}
