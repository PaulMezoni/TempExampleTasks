package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayListEx {
    public static void main(String[] args) {
        List<Letter> letter = new ArrayList<>();
        letter.add(new Letter("A"));
        letter.add(new Letter("B"));
        letter.add(new Letter("C"));
        System.out.println(letter);

        List<Letter> letter2 = new ArrayList<>(letter);
        letter2.add(new Letter("D"));
        letter2.add(new Letter("E"));
        letter2.add(new Letter("F"));
        System.out.println(letter2);

        System.out.println(letter2.get(1) + " get element index 1 ");

//        List<Letter> newList = letter2.subList(4, 6);
//        System.out.println(newList);

        Letter[] arr = letter.toArray(new Letter[3]);
        for (Object s : arr) {
            System.out.println(s);
        }
        System.out.println(Arrays.toString(arr) + " arr");

        List<Letter> listCopy = List.copyOf(letter2);
        System.out.println(listCopy + " copy listLetter2");


//        Student st1 = new Student("A", 31);
//        boolean contains = studentList.contains(st1);
//        System.out.println(contains);
    }

    static class Letter {
        private final String name;

        public Letter(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Letter letter)) return false;
            return Objects.equals(name, letter.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Letter{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
