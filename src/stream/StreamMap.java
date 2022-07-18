package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
//        List<String> list = List.of("ten", "nine", "sixty", "ninety", "seventy", "sixtysix");

        int[] x = {1, 2, 9};
        double[] s = {51.17, 55.99};
        String[] strings = {"a", "b", "a", "b", "x"};

//        System.out.println(stringsi);
//        System.out.println(isPalindrome(string));
//        Arrays.stream(s).boxed().sorted(Comparator.reverseOrder()).map(el -> Math.round(el * 30))
//                .forEach(sout -> System.out.println(sout + " цена за 20 литров в Крыму"));

        System.out.println(deleteDuple(new ArrayList<>(List.of("a", "b", "c", "a", "b", "c"))));
        System.out.println(deleteDuple2(List.of("a", "b", "c", "a", "b", "c")));
        System.out.println(deleteDuple(new ArrayList<>(List.of("x", "a", "b", "c", "x"))));
        System.out.println(deleteDuple2(List.of("x", "a", "b", "c", "x")));
//        System.out.println(deleteDuple(new ArrayList<>(List.of("x", "x", "a", "b", "c", "x"))));
//        System.out.println(deleteDuple(new ArrayList<>(List.of("x", "x", "a", "b", "c", "x", "x"))));
//        System.out.println();
//        System.out.println(deleteDuple(new ArrayList<>(List.of(1, 2, 3, 1, 2, 3))));
//        System.out.println(deleteDuple(new ArrayList<>(List.of(1, 2, 3, 3))));
//        System.out.println(deleteDuple(new ArrayList<>(List.of(10, 10, 1, 2, 3))));
//        System.out.println(deleteDuple(new ArrayList<>(List.of(10, 10, 10, 1, 2, 3, 3, 2, 1, 8))));
//        System.out.println(deleteDuple(new ArrayList<>(List.of(10, 10, 1, 2, 3, 10, 10))));

//        System.out.println(Arrays.toString(nonRepeating(new int[]{1, 2, 3, 1, 2, 4})));
    }

    //    static <T> List<T> deleteDuple(List<T> list) {
//        return list.stream()
//                .filter(x -> list.stream()
//                        .filter(x::equals).count() < 2)
//                .collect(Collectors.toList());
//    }
    static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    static int[] nonRepeating(int[] arr) {
        int res = 0;
        for (int val : arr) {
            res ^= val;
        }
        return new int[]{res};
    }

    static <T> List<T> deleteDuple2(List<T> list) {
        return list.stream().filter(r -> list.stream().filter(r::equals).count() < 2).collect(Collectors.toList());
    }

    static <T> List<T> deleteDuple(List<T> list) {
        T x;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
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
