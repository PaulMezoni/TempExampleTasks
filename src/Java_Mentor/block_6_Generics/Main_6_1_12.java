package Java_Mentor.block_6_Generics;

import java.util.Objects;

//6.1.12
public class Main_6_1_12 {
//6.1.12
//Реализуй этот класс
public static class Pair<T, Y> {

    private final T first;
    private final Y second;

    private Pair(T first, Y second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Pair<?, ?> pair)) return false;
//        return Objects.equals(getFirst(), pair.getFirst()) && Objects.equals(getSecond(), pair.getSecond());
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) { // проверка на null и на принадлежность к классу
            return false;
        }
        // создаешь объект pair из o, чтобы дальше работать с ним
        Pair<?, ?> pair = (Pair<?, ?>) o;
        // сравниваешь твои поля в объекте, а именно first и second с аналогичными в новосозданном из о pair
        return Objects.equals(first, pair.getFirst()) && Objects.equals(second, pair.getSecond());
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.getFirst(), this.getSecond());
    }

//        public static <T, T1> Pair<T, T1> of(T value, T1 value1) {
//            return new Pair<T, T1>(value, value1);
//        }

    public static <T, Y> Pair<T, Y> of(T first, Y second) {
        return new Pair<>(first, second);
    }
}

public static void main(String[] args) {
    Pair<Integer, String> pair = Pair.of(1, "hello");
    Integer i = pair.getFirst(); // 1
    String s = pair.getSecond(); // "hello"
    Pair<Integer, String> pair2 = Pair.of(1, "hello");
    boolean mustBeTrue = pair.equals(pair2); // true!
    boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
}

}
