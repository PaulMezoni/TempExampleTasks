package Java_Mentor.block_7_API;

import java.util.function.Predicate;

public class Functions {

    @FunctionalInterface
    public interface Comparator<T> {
        int compare(T o1, T o2);

        boolean equals(Object obj);
        // другие default или static методы
    }

    //Определяем свой функциональный интерфейс
    @FunctionalInterface
    interface MyPredicate {
        boolean test(Integer value);
    }
     final

    public static class Tester {
        public static void main(String[] args) throws Exception {
            MyPredicate myPredicate = x -> true;
            System.out.println(myPredicate.test(10));   //true

            //Аналогично, но используется встроенный функциональный интерфейс java.util.function.Predicate
            Predicate<Integer> predicate = x -> x > 0;
            System.out.println(predicate.test(-10));    //false
        }
    }
}

