package Java_Mentor.block_7_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_7_2_11 {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        //твой код здесь
        List<?extends T> element = stream.sorted(order).collect(Collectors.toList());
        if (!element.isEmpty()) {
            minMaxConsumer.accept(element.get(0), element.get(element.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void main(String[] args) throws Exception {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21)).stream();

        findMinMax(
                stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.printf("min: %s, max: %s%n", x, y)
        );

        stream.close();
    }
}
