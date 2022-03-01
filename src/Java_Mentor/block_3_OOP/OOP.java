package Java_Mentor.block_3_OOP;

public class OOP {
    public static void main(String[] args) {

//        Person person = new Person("dfcz", 5);

        final String name = "Геральд из Ривии";
        final int value = 0;
//        System.out.println(value + name);

//        Cat cat1 = new Cat();
//        Cat cat2 = new Cat();
//
//        System.out.println("Имя первого кота: " + cat1.name);
//        System.out.println("Возраст первого кота: " + cat1.age);
//        System.out.println();
//        System.out.println("Имя второго кота: " + cat2.name);
//        System.out.println("Возраст второго кота: " + cat2.age);

        Cat cat3 = new Cat("Рыжик", 5);
//        Cat cat4 = new Cat("Барсик", 9);

        System.out.println();
        System.out.println("Имя третьего кота: " + Cat.name);
        System.out.println("Возраст третьего кота: " + Cat.age);
//        System.out.println();
//        System.out.println("Имя четвертого кота: " + cat4.name);
//        System.out.println("Возраст четвертого кота: " + cat4.age);


    }

    static class Cat {
        static String name;
        static int age;

        public  Cat(String name, int age) {
            Cat.name = name;
            Cat.age = age;
        }

        public Cat() {
        }
    }

    static class Person{
        String name;
        int age;
    }

}
    