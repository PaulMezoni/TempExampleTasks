package multithreading;

public class Ex7 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Thread7());
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(i + " hello");
            Thread.sleep(10);
        }


    }

    static class Thread7 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + " thread 7");

            }
        }
    }
}
