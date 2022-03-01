package stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamAccumulator {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 6, 8);


        int result = list.stream().reduce(2, (accumulator, element) -> accumulator * element);
        System.out.println(result);

        List<Integer> list2 = list.stream().sorted(Comparator.naturalOrder()).toList();
//        System.out.println(list2);

        Stream<Integer> list3 = Stream.of(2, 4, 6, 8);
        Stream<Integer> list4 = Stream.of(2, 4, 6, 8);
        List<Integer> list5 = Stream.concat(list3, list4).toList();
//        list5.stream().sorted().forEach(System.out::print);

        long count = list5.stream()
//                .map(x -> x + " ")
                .peek(x -> System.out.print(x + " "))
                .distinct()
//                .peek(x -> System.out.print(x + "\n element after"))
                .count();
        System.out.println(count);
    }
}
