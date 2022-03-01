package stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("poka");
        list.add("poka");
        list.add("ABC");

//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
//        System.out.println(list);

        List<Integer> list2 = list.stream().map(el -> el.length()).collect(Collectors.toList());
        System.out.println(list2);

        Set<Integer> set = new TreeSet<>(list2);
        set.stream().map(x -> x + " ").forEach(System.out::print);


//        int[] array = {1, 2, 3, 7, 8, 9, 5, 4, 6};
//        array = Arrays.stream(array).map(operand -> {
//            if (operand % 3 == 0) {
//                operand = operand / 3;
//            }
//            return operand;
//        }).toArray();
//        System.out.println(Arrays.toString(array));
    }

}
