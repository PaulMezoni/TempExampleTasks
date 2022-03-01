package stream;

import java.util.stream.IntStream;

public class StreamInfinity {
    public static void main(String[] args) {

        IntStream.iterate(10, i -> i + 1)
                .limit(10)
                .skip(5).sorted()
                .forEach(value -> System.out.print(" " + value));

//3. бесконечный стрим
//        IntStream.iterate(0, i -> (i + 1) % 2)
//                .distinct()
//                .limit(10)
//                .forEach(System.out::println);

//        4. Случайно создан «скрытый» параллельный бесконечный поток
//        IntStream.iterate(0, i -> ( i + 1 ) % 2)
//                .parallel()
//                .distinct()
//                .limit(10)
//                .forEach(System.out::println);

//        Set<Integer> uniqueValues = new HashSet<>();
//        for (int i = 0; ; i = (i + 1) % 2) {
//            if (uniqueValues.add(i)) {
//                System.out.println(i);
//            }
//        }

    }
}
