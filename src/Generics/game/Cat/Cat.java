package Generics.game.Cat;

public class Cat {
    private int age;
    private String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        if (getAge() != cat.getAge()) return false;
        return getName() != null ? getName().equals(cat.getName()) : cat.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getAge();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
