package Generics.game;

public abstract class Participant {
    private final String name;
    private final Integer age;

    public Participant(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
