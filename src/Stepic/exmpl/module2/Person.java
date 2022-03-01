package Stepic.exmpl.module2;

import java.util.Objects;

public class Person {
    String name;
    Integer age;
    Integer number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(number, person.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, number);
    }


    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.hashCode());
        System.out.println(hash(person));
    }

    static int hash(Object key) {
        int h;
        return (h = key.hashCode()) ^ (h >>> 16);
    }
}
