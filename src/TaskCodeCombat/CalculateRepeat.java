package TaskCodeCombat;

import java.util.*;

public class CalculateRepeat {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 1, 2, 3, 4, 5, 6);
        List<String> list2 = new ArrayList<>();
        int[] x = {1, 2, 2, 3, 3, 3, 4, 5, 6};
        list2.add("1");
        list2.add("1");
        list2.add("Car");
        list2.add("CAR");
        list2.add("3");
        System.out.println(calculateRepeat(x));
    }

    private static Map<Integer, Integer> calculateRepeat(int[] x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : x) {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else map.put(k, 1);
        }
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        return map;
    }
}
