package Java_Mentor.block_7_API;

public class Main_7_1_8 {
//Твой код здесь
@FunctionalInterface
interface NumberGenerator<T extends Number> {
    boolean cond(T arg);
}

public static NumberGenerator<? super Number> getGenerator() {
    // и здесь
    return x -> x.intValue() > 0;
}

    public static void main(String[] args) {
        NumberGenerator<? super Number> numGen = getGenerator();
        System.out.println(numGen.cond(123456L)); // true
        System.out.println(numGen.cond(123456.56)); // true
        System.out.println(numGen.cond(132)); // true
        System.out.println(numGen.cond(Byte.MAX_VALUE)); //true
        System.out.println(numGen.cond(-5.5)); //false
        System.out.println(numGen.cond(-1253523525L));
        System.out.println(numGen.cond(0));
        System.out.println(numGen.cond(-2));
        System.out.println(numGen.cond(Byte.MIN_VALUE));
        System.out.println(getGenerator().cond(5));
    }
}
