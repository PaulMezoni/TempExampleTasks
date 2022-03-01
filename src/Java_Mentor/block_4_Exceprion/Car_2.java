package Java_Mentor.block_4_Exceprion;


// 4.2.7
public class Car_2 {
    //Твой код здесь
    public static class Car_1 implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Машина закрывается...");
        }

        public void drive() {
            System.out.println("Машина поехала.");
        }
    }

    public static void main(String[] args) {
        //Твой код здесь
        try (Car_1 car = new Car_1()) {
            car.drive();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }
}

