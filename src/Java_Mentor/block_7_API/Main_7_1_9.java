package Java_Mentor.block_7_API;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main_7_1_9 {

public static <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {
    //Твой код здесь
    return (t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t));
}

public static void main(String[] args) {
    Predicate<Object> condition = Objects::isNull;
    Function<Object, Integer> ifTrue = obj -> 0;
    Function<CharSequence, Integer> ifFalse = CharSequence::length;
    Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
    System.out.println(safeStringLength.apply("Hello"));
    System.out.println(safeStringLength.apply(null));
}
}
