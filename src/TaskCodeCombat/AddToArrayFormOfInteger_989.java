package TaskCodeCombat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//  989. Add to Array-Form of Integer
public class AddToArrayFormOfInteger_989 {
    public static void main(String[] args) {

        int[] x0 = {1, 2, 0, 0};
        int[] x1 = {9, 9, 9, 9, 9, 9, 9};
        int[] x2 = {2, 6, 3, 0, 7, 1, 7, 1, 9, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 3, 3, 2, 3, 3, 3, 3, 3, 1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5, 4, 5, 7, 5, 6, 6, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int k = 12;

        System.out.println(addToArrayForm3(x0, k));
        System.out.println(addToArrayForm3(x1, k));
        System.out.println(addToArrayForm3(x2, k));

        System.out.println(addToArrayForm(x0, k) + " first method ");
        System.out.println(addToArrayForm(x1, k) + " first method ");
        System.out.println(addToArrayForm(x2, k) + " first method ");


    }

    static List<Integer> addToArrayForm3(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = a.length; i-- > 0 && k > 0; ) {
            list.add(0, (a[i] + k) % 10);
//            k += a[i];
//            a[i] = k % 10;
            k = (a[i] + k) / 10;
        }
        if (k == 0) {
            return list;
        }
        return Collections.singletonList(-1);
    }

    public static List<Integer> addToArrayForm(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = a.length; i-- > 0; ) {
            list.add(0, (a[i] + k) % 10);
            k = (a[i] + k) / 10;
        }
        while (k > 0) {
            list.add(0, k % 10);
            k /= 10;
        }
        return list;
    }

    public static List<Integer> addToArrayForm2(int[] num, int k) {
        int i = num.length - 1;
        List<Integer> list = new ArrayList<>();
        for (int j = i; j >= 0; j--) {
            list.add(i, j);
            i--;
        }
        if (i >= 0) {
            num[i]++;
        }

        return Arrays.stream(num).boxed().collect(Collectors.toList());
    }
}
