package TaskCodeCombat;

import java.util.ArrayList;
import java.util.List;

public class TestEx1 {
    public static void main(String[] args) {
//        Person p = new Person(1, "Paul", 2);
//        Person p1 = new Person(2, "Max", 3);
//        Person p2 = new Person(3, "Lana", 4);
//        Person p3 = new Person(4, "Deli", 3);

        List<Person> list = new ArrayList<>();
//        list.add(p);
//        list.add(p1);
//        list.add(p2);
//        list.add(p3);

        System.out.println(list);

        aVoid((list), 2);

    }

    public static void aVoid(List<Person> p, Integer average) {
        for (Person  s : p) {
            if (s.average > average) {
                System.out.println(s);
            }
        }
    }
}
