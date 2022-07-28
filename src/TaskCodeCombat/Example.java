package TaskCodeCombat;

import java.util.*;

public class Example {
    public static void main(String[] args) {

        String[] a = {"a", "b", "c"};
        String[] b = a;
        System.out.println(Arrays.toString(b) + " array abc");

        int firstElement;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        boolean firstElement1 = set.contains(3);
        System.out.println(firstElement1);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        firstElement = list.get(1);
        System.out.println(firstElement);

        List<Integer> integerList = new LinkedList<>();
        integerList.add(5);
        integerList.add(6);
        firstElement = integerList.get(1);
        System.out.println(firstElement);

        for (int i = 0; i < 3; i++) {
            int[] x = new int[3];
            x[i] = 1;
            for (int k : x) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println(method(2, 3) + " hello ");
    }

    static Integer method(Integer a, Integer b) {
        return a + b;
    }
}

