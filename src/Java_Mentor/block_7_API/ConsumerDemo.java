package Java_Mentor.block_7_API;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase() + " " + s);
        Consumer<String> consumer2 = s -> System.out.println(s.toLowerCase());
        consumer.accept("love 123123");
        consumer2.accept("LOVE 123123");

        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        Integer i3 = new Integer(128);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
    }
}
