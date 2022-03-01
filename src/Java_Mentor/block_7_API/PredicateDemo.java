package Java_Mentor.block_7_API;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        predicateMethod("123");
        predicateMethod("");
    }

    static void predicateMethod(String str) {
        Predicate<String> stringPredicate = s -> {
            if (s != null && !s.isEmpty()) {
                System.out.println(" string contains elements");
            } else {
                System.err.println(" string is empty");
            }
            return false;
        };
        stringPredicate.test(str);
    }
}
