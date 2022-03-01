package Calculator;

public class Car {

    private final String name;
    private final Integer number;
    private final String color;

    public Car(String name, Integer number, String color) {
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }
}
