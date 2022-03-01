package Java_Mentor.block_7_API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main_7_2_12 {
    public static void main(String[] args) throws Exception {
        //Твой код здесь
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.lines().map(line -> line.toLowerCase().replaceAll("\\p{Punct}\\s", " ").split("\\s+"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    //
                    .peek(((e) -> System.out.print("," + e)))
                    //
                    .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue)
                            .reversed())
                    .map(Map.Entry::getKey).limit(10)
                    .forEach(System.out::println);
        }
    }
}


