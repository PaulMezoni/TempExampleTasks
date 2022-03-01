package Java_Mentor.block_6_Generics;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main_6 {
    public static void main(String[] args) {

        class Saison {
            public int id;
            public String name;

            public Saison(int id, String name) {
                this.id = id;
                this.name = name;
            }
//            @Override
//            public boolean equals(Object obj) {
//                return (id == ((Saison)obj).id && name.equals(((Saison) obj).name));
//            }
        }

        List<Saison> list = new ArrayList<Saison>();
        list.add(new Saison(1, "Весна"));
        list.add(new Saison(2, "Лето"));
        list.add(new Saison(3, "Осень"));
        list.add(new Saison(4, "Зима"));

        System.out.println("Весна " + list.contains(new Saison(1, "Весна")));

        TreeMap<Integer, String> map = new TreeMap<>();
        // Добавляем данные
        map.put(1, "Понедельник");
        map.put(2, "Вторник");
        map.put(3, "Среда");
        map.put(4, "Четверг");
        map.put(5, "Пятница");
        map.put(6, "Суббота");
        map.put(7, "Воскресенье");
//        System.out.println(map);


        Collection<?> collection = new CopyOnWriteArrayList<>();
        Object object = new Object();

        collection.size();
        collection.iterator();
        collection.clear();
        collection.contains(object);
        collection.toArray();
        collection.remove(object);

//        collection.add(object); // not work
//        collection.addAll(Arrays.asList(object)); // not work

//        Set set = new LinkedHashSet<>();
        Set<String> set = new LinkedHashSet<>();
        // add some elements to the set
        Iterator iterator = set.iterator();
        System.out.println(iterator);
    }
}