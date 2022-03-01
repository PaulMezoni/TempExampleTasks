package Calculator;

public class AbstractClass extends AbstractClass2{
    private final String postCode = "33333";
    public void createAddress() {
          int houseNumber = 34;

         class Street {
            public void printAddress() {
                System.out.println("PostCode is " + postCode);
                System.out.println("House Number is " + houseNumber);
            }
        }
        Street street = new Street();
        street.printAddress();
    }

    public static void main(String[] args) {
        AbstractClass town = new AbstractClass();
        town.createAddress();

    }
}