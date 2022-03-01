package arrayListExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array_List {
    //    Stream
    volatile String name;
    volatile String names;

    public static void addRectangle(List<? super Number> num) {
        num.add(0);
        num.add(0.2);
        num.add(0.2);

    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Max");
        list.add("Maximus");
        list.add("Maximilian");
        System.out.println(list + " before");

        List<String> list1 = new ArrayList<>(list);
        list1.add(1, "Markus");
        System.out.println(list1 + " after");
        Collections.sort(list1);

        System.out.println(list1);
        List list2 = new ArrayList();
        list2.add(2);
        list2.add("adlsf");
        System.out.println(list2);


//        Stream
//                .of(1, 2, 3, 7, 6, 8)
//                .filter(s -> s % 2 == 0)
//                .mapToLong(p -> (long) Math.pow(p, 32))
//                .distinct()
//                .sorted()
//                .forEachOrdered(System.out::println);


    }

}

