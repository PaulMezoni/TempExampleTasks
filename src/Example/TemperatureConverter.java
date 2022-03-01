package Example;

public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println(convertTemp(35, 'K'));

    }

    public static String convertTemp(int temperature, char convertTo) {
        switch (convertTo) {
            case 'C', 2 -> System.out.print(temperature);
            case 'F' -> System.out.print((temperature * 9 / 5) + 32);
            case 'K' -> System.out.print((temperature + 273));
        }
        return String.valueOf(convertTo);
    }
}
