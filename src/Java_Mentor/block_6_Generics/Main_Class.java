package Java_Mentor.block_6_Generics;

import java.util.*;

public class Main_Class {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Весна");
        list.add("Лето");
        list.add("Осень");
        list.add("Зима");

        System.out.println(list);
        System.out.println(" " + list.contains("Лето"));

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
//        nums.add(3.14); // compile-time error
//        System.out.println(ints);
//        System.out.println(nums);

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        Gen<?> gen = new Gen<>(); //<Integer>
        gen.m(integerList);

//        List<String>[] stringLists = new List<String>[1];  //  (1)
//        List<Integer> intList = Arrays.asList(42, 65, 44);  //  (2)
//        Object[] objects = stringLists;  //  (3)
//        objects[0] = intList;  //  (4)
//        String s = stringLists[0].get(0);  //  (5)

    }

    static class Gen<T> {
        <T> void m(Collection<T> collection) {
            for (T s : collection) {
                System.out.println(s);
            }
        }

        <T> void m(List<String> list) { //ClassCastException
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}


