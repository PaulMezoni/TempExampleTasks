package Java_Mentor.block_7_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {

        numberCheck(-1);
        numberCheck(0);
        numberCheck(1);

//        AtomicReference<Map<Integer, BiFunction<Integer, Integer, Integer>>> functionMap = new AtomicReference<>();
//        functionMap.get().put(0, Integer::sum);
//        functionMap.get().put(1, (a, b) -> a - b);
//        functionMap.get().put(2, (a, b) -> a * b);
//        functionMap.get().put(3, (a, b) -> a / b);
//        functionMap.get().put(4, (a, b) -> a % b);

        String str = null;
        Function<String, Boolean> booleanStringFunction = Boolean::valueOf;
        System.out.println(booleanStringFunction.apply(str) + "123");


//        BiFunction<Integer, String, String> biFunction = (integer, s) ->
    }

    static {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 5, 10));
        Integer reduce = list.stream().reduce(0, Integer::sum);
//        Integer reduce = list.stream().reduce(0, (v1, v2) -> v1 + v2); //identity
        System.out.println(reduce); // result is: 20
    }

    static void numberCheck(Integer i) {
        Function<Integer, String> function = s -> {
            String result = null;
            if (i < 0) {
                System.out.println(" negative number");
            } else if (i > 0) {
                System.out.println(" positive number");
            } else {
                System.out.println(" zero");
            }
            return result;
        };
        function.apply(i);
    }
}
