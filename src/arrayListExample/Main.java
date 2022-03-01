package arrayListExample;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        List<Integer> list = List.of(1, 500, 2, 120, 311, 100);
        System.out.println(list(list));

        int[] a = {1, 2, 3, 45, 234};
        int target = 45;
    }



    public static List<Integer> list(List<Integer> list) {
        return list.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
    }
}
