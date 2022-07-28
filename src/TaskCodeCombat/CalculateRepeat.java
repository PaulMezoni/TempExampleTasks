package TaskCodeCombat;

import java.util.*;

public class CalculateRepeat {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("name1", "Max");
        map.computeIfPresent("name2", (k, v) -> "Paul");
//        map.put("question", "Bla?");
        map.merge("question", " Blabla", (oldVal, newVal) -> oldVal + newVal);
        map.merge("name", "Maximus", (k, v) -> "");
        String v = map.getOrDefault("name", "");
        System.out.println(map.get("question")); // Bla? Blabla
        System.out.println(v);
        System.out.println(map);

        List<Integer> list = List.of(1, 2, 3, 1, 2, 3, 4, 5, 6);
        List<String> list2 = new ArrayList<>();
        int[] x = {1, 2, 2, 3, 3, 3};
        System.out.println(calculateRepeat(x));
    }

    private static Map<Integer, Integer> calculateRepeat(int[] x) {
        Map<Integer, Integer> map = new HashMap<>();
        return map;
    }
}
