package Example;

public class ConvertTemperature {
    public static void main(String[] args) {
        double temperature = 36.0;
        System.out.println(new Celsius().converter(temperature));
        System.out.println(new Fahrenheit().converter(temperature));
        System.out.println(new Kelvin().converter(temperature));

    }

    static class Celsius implements Converter {

        @Override
        public double converter(double valueTemp) {
            return valueTemp;
        }
    }

    static class Fahrenheit implements Converter {

        @Override
        public double converter(double valueTemp) {
            return (valueTemp * 9 / 5) + 32;
        }
    }

    static class Kelvin implements Converter {

        @Override
        public double converter(double valueTemp) {
            return valueTemp + 273;
        }
    }

}
