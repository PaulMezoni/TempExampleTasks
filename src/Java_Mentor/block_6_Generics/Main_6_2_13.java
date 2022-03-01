package Java_Mentor.block_6_Generics;

import java.util.HashSet;
import java.util.Set;

public class Main_6_2_13 {
    public static void main(String[] args) {

        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        HashSet<Integer> s2 = new HashSet<>();
        s2.add(0);
        s2.add(1);
        s2.add(2);

        Set<Integer> result = symmetricDifference(s1, s2);
        System.out.println(result);

    }
//6.2.13

    /**
     * Реализуйте метод, вычисляЧющий симметрическую разность двух множеств.
     * Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
     * Пример:
     * Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
     */
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        //твой код здесь
        Set<T> numbers1 = new HashSet<T>(set1);
        numbers1.removeAll(set2);

        Set<T> numbers2 = new HashSet<T>(set2);
        numbers2.removeAll(set1);

        numbers1.addAll(numbers2);
        return numbers1;
    }

//    removeAll(Collection c) — удаляет элементы, принадлежащие переданной коллекции
//    retainAll(Collection c) — удаляет элементы, не принадлежащие переданной коллекции

// 2 решение
//        Set<ComplexNumbers> set = new HashSet<>();
//        set.addAll((Collection<? extends ComplexNumbers>) set1);
//        set.addAll((Collection<? extends ComplexNumbers>) set2);
//
//        Iterator<T> it = (Iterator<T>) set.iterator();
//        while (it.hasNext()) {
//            T item = it.next();
//            if (set1.contains(item) && set2.contains(item)) {
//                it.remove();
//            }
//        }
//        return (Set<T>) set;
//    }
}

