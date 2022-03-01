package Java_Mentor.block_7_API;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {

        UnaryOperator<Integer> uo = Integer::intValue;
        System.out.print(uo.apply(100));
    }
}
