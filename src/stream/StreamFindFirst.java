package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamFindFirst {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 3, 2, 5, 6);
        List<Double> list2 = List.of(4.0, 3.0, 2.0, 5.0, 6.0);

        Optional<Integer> stream = list.stream()
                .peek(e -> {
                    System.out.print(" " + e);
                })
                .sorted()
                .findFirst();
        System.out.println();
        System.out.println(stream);
        list.stream().sorted().map(x -> x + " ").forEach(System.out::print);
        System.out.println();
        list.stream().min(Comparator.comparingInt(x -> x)).ifPresent(System.out::println);
        list.stream().skip(3).limit(1).forEach(System.out::println);

        List<Double> integers = list.stream()
                .sorted(Comparator.reverseOrder())
                .mapToDouble(e -> e)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integers);

        list.parallelStream().reduce((x, y) -> x * y).stream().toList().forEach(System.out::println);
        list2.parallelStream().sorted()
                .peek(e -> System.out.println(" " + e))
                .reduce((x, y) -> x / y)
                .ifPresent(System.out::println);

    }
}
