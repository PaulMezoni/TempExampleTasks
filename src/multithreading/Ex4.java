package multithreading;

public class Ex4 {
    public static void main(String[] args) {
        // thread first
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + " Ex4 ");
            }
        }).start();

        //thread second
        new Thread(() ->
        {
            for (int i = 0; i < 100; i++) {
                System.out.println(" Hello");
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            System.out.println(" thread main");
        }
    }
}
