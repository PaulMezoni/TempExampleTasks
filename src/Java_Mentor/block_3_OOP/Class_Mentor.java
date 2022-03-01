package Java_Mentor.block_3_OOP;

import Java_Mentor.Solution;

public class Class_Mentor {
    public static void main(String[] args) {

        float amount = 1.7F;
        float avalue = 0.1F;
        float result = amount + avalue;
//        System.out.println(result);

        double positive_infinity = -12.0 / 0;
//        System.out.println(positive_infinity);

        double positive_infinity1 = 12.0 / 0;
        double negative_infinity = -15.0 / 0;
//        System.out.println(positive_infinity1 + negative_infinity);

        Cat cat = new Cat();
        Dog dog = new Dog();
//        dog.catchCat(cat);
        Solution solution = new Solution();

        int a = Integer.parseInt("42");
//        System.out.println(a);

        Human human = new Human();
        Human human2 = new Human((byte) 30, "Dwayne", "Wade", "Basketball");
        Human human3 = new Human((byte) 30, "Joe", "Cash");

    }


    // 3.3.11
    public static class Cat {
        public void sayHello() {
            System.out.println("Мяу!");
        }
    }

    public static class Dog {
        public void sayHello() {
            System.out.println("Гав!");
        }

        public void catchCat(Cat cat) {
            System.out.println("Кошка поймана");
            this.sayHello();
            cat.sayHello();
        }
    }

    // 3.3.12
    public static class Human {
        //TODO your code here
        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human() {
        }

        public Human(byte age, String name, String secondName, String favoriteSport) {
            this(age, name, secondName);
            this.favoriteSport = favoriteSport;
        }

        public Human(byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }
    }

    public static class Human2 {
        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human2() {
        }

        public Human2(byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }

        public Human2(byte age, String name, String secondName, String favoriteSport) {
            this(age, name, secondName);
            this.favoriteSport = favoriteSport;
        }
    }
}
