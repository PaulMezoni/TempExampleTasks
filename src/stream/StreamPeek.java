package stream;

import java.util.stream.Stream;

public class StreamPeek {
    public static void main(String[] args) {

        boolean b = Stream.of("a", "b", "c")
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .anyMatch("B"::equals);
        System.out.println(b);


    }
}
