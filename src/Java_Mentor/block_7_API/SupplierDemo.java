package Java_Mentor.block_7_API;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        String s = "one";
        Supplier<String> stringSupplier = s::toLowerCase;
        System.out.println(stringSupplier.get());

        integer();

    }

    static void integer() {
        Supplier<Integer> integerSupplier = () -> (int) (Math.random() * 100);
        System.out.println(integerSupplier.get());

    }

}
