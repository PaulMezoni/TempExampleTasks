package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) throws InterruptedException {
//        List<String> list = List.of("ten", "nine", "sixty", "ninety", "seventy", "sixtysix");

        int[] x = {1, 2, 9};
        double[] s = {51.17, 55.99};
        String[] strings = {"a", "b", "a", "b", "x"};
        String[] str = {"A", "B", "C", "D"};

        // преобразовать массив в список
        List<String> list = convertToList(str);
        List<String> list1 = new ArrayList<>(Arrays.asList(str));
        // распечатать список
//        System.out.println(list1);
//        System.out.println(stringsi);

//        Arrays.stream(s).boxed().sorted(Comparator.reverseOrder()).map(el -> Math.round(el * 30))
//                .forEach(sout -> System.out.println(sout + " цена за 20 литров в Крыму"));

        System.out.println("deleteDuple1 " + deleteDuple1(new ArrayList<>(List.of("a", "b", "c", "a", "b", "c"))));
        System.out.println("deleteDuple2 " + deleteDuple2(new ArrayList<>(List.of("a", "b", "c", "a", "b", "c"))));
        System.out.println("deleteDuple3 " + deleteDuple3(new ArrayList<>(List.of("a", "b", "c", "a", "b", "c"))));
        System.out.println();
        System.out.println("deleteDuple1 " + deleteDuple1(new ArrayList<>(List.of("x", "a", "b", "c", "x"))));
        System.out.println("deleteDuple2 " + deleteDuple2(new ArrayList<>(List.of("x", "a", "b", "c", "x"))));
        System.out.println("deleteDuple3 " + deleteDuple3(new ArrayList<>(List.of("x", "a", "b", "c", "x"))));
        System.out.println();
        System.out.println("deleteDuple1 " + deleteDuple1(new ArrayList<>(List.of("x", "x", "a", "b", "c", "x"))));
        System.out.println("deleteDuple2 " + deleteDuple2(new ArrayList<>(List.of("x", "x", "a", "b", "c", "x", "x"))));
        System.out.println("deleteDuple3 " + deleteDuple3(new ArrayList<>(List.of("x", "x", "a", "b", "c", "x", "x"))));
        System.out.println();
        System.out.println("deleteDuple1 " + deleteDuple1(new ArrayList<>(List.of(1, 2, 3, 1, 2, 3))));
        System.out.println("deleteDuple2 " + deleteDuple2(new ArrayList<>(List.of(1, 2, 3, 1, 2, 3))));
        System.out.println("deleteDuple3 " + deleteDuple3(new ArrayList<>(List.of(1, 2, 3, 1, 2, 3))));
        System.out.println();
        System.out.println("deleteDuple1 " + deleteDuple1(new ArrayList<>(List.of(1, 2, 3, 3))));
        System.out.println("deleteDuple2 " + deleteDuple2(new ArrayList<>(List.of(1, 2, 3, 3))));
        System.out.println("deleteDuple3 " + deleteDuple3(new ArrayList<>(List.of(1, 2, 3, 3))));
        System.out.println();
        System.out.println("deleteDuple1 " + deleteDuple1(new ArrayList<>(List.of(10, 10, 1, 2, 3))));
        System.out.println("deleteDuple2 " + deleteDuple2(new ArrayList<>(List.of(10, 10, 1, 2, 3))));
        System.out.println("deleteDuple3 " + deleteDuple3(new ArrayList<>(List.of(10, 10, 1, 2, 3))));
        System.out.println();
        System.out.println("deleteDuple1 " + deleteDuple1(new ArrayList<>(List.of(10, 10, 10, 1, 2, 3, 3, 2, 1, 8))));
        System.out.println("deleteDuple2 " + deleteDuple2(new ArrayList<>(List.of(10, 10, 10, 1, 2, 3, 3, 2, 1, 8))));
        System.out.println("deleteDuple3 " + deleteDuple3(new ArrayList<>(List.of(10, 10, 10, 1, 2, 3, 3, 2, 1, 8))));
        System.out.println();
        System.out.println("deleteDuple1 " + deleteDuple1(new ArrayList<>(List.of(10, 10, 1, 2, 3, 10, 10))));
        System.out.println("deleteDuple2 " + deleteDuple2(new ArrayList<>(List.of(10, 10, 1, 2, 3, 10, 10))));
        System.out.println("deleteDuple3 " + deleteDuple3(new ArrayList<>(List.of(10, 10, 1, 2, 3, 10, 10))));

//        System.out.println(Arrays.toString(nonRepeating(new int[]{1, 2, 3, 1, 2, 4})));
    }

    //    static <T> List<T> deleteDuple(List<T> list) {
//        return list.stream()
//                .filter(x -> list.stream()
//                        .filter(x::equals).count() < 2)
//                .collect(Collectors.toList());
//    }

    static int[] nonRepeating(int[] arr) {
        int res = 0;
        for (int val : arr) {
            res ^= val;
        }
        return new int[]{res};
    }

    static <T> List<T> deleteDuple3(List<T> list) {
        return list.stream().filter(r -> list.stream().filter(r::equals).count() == 1).collect(Collectors.toList());
    }

    static <T> List<T> deleteDuple2(List<T> list) {
        T x;
        int count = 0;
        for (int i = 0; i < list.size(); ) {
            x = list.get(i);
            for (T t : list) {
                if (x == t) {
                    count++;
                }
            }
            if (count > 1) {
                count = 0;
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (x == list.get(j)) {
                        list.remove(x);
                    }
                }
            } else if (count == 1) {
                count = 0;
                i++;
            }
        }
        return list;
    }

    static <T> List<T> deleteDuple1(List<T> list) {
        T x;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == (list.get(j))) {
                    x = list.get(i);
                    for (int k = list.size() - 1; k >= 0; k--) {
                        if (x == list.get(k)) {
                            list.remove(x);
                        }
                    }
                    i--;
                    break;
                }
            }
        }
        return list;
    }

    public static <T> List<T> convertToList(T[] arr) {
        // создаем пустой список
        // помещаем каждый элемент массива в список
        // возвращаем список
        return new ArrayList<>(Arrays.asList(arr));
    }

    static <S> S strings(List<S> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            // Начинаем переход вперед из списка с индексом list.size () - 1
            for (int j = list.size() - 1; j > i; j--) {
                // Сравнить
                if (list.get(j).equals(list.get(i))) {
                    // дедупликация
                    list.remove(j);
                }
            }
        }
        return (S) list;
    }
}
