package collections;

import java.util.LinkedList;
import java.util.Objects;

public class LinkedListEx {
    public static void main(String[] args) {
        LinkedList<Letter2> letter2s = new LinkedList<>();
        letter2s.add(new Letter2("A"));
        letter2s.add(new Letter2("B"));
        letter2s.add(new Letter2("C"));

        System.out.println(letter2s.get(2));
    }
}

class Letter2 {
    private final String name;

    public Letter2(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Letter2 letter2)) return false;
        return Objects.equals(name, letter2.name);
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