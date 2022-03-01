package Java_Mentor.block_7_API;

import java.util.stream.IntStream;

public class Main_7_2_10 {
    public static IntStream pseudoRandomStream(int seed) {
        //твой код здесь
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }

    public static void main(String[] args) {
        IntStream res = pseudoRandomStream(13);
        res.limit(10).forEach(x -> System.out.print(x + " "));
    }
}
