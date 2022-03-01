package Java_Mentor.block_7_API;

import java.util.function.UnaryOperator;

public class Main_7_1_7 {
    public static void main(String[] args) {
        Main main = new Main(); //ваш класс
        UnaryOperator<Integer> unaryOperator = main.sqrt();
        System.out.println("2 -> " + unaryOperator.apply(2));
        System.out.println("-4 -> " + unaryOperator.apply(-4));
        System.out.println("6 -> " + unaryOperator.apply(6));
        System.out.println("12 -> " + unaryOperator.apply(12));
        System.out.println("5 -> " + unaryOperator.apply(5));
        UnaryOperator<Integer> operator = x -> x * x;
        System.out.println(operator.apply(5)); // 25
    }

    static class Main {
        public UnaryOperator<Integer> sqrt() {
            //Твой код здесь
            return x -> x * x;
        }
    }
}
