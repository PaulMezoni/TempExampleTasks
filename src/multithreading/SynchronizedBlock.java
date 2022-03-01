package multithreading;

public class SynchronizedBlock {

    static class Counter {
        static int counter = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        R runnable = new R();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();

    }

    static class R implements Runnable {
        private void method() {
            System.out.print("HH");
        }


        private void increment() {
            method();

             //synchronized
            synchronized (this) {
                Counter.counter++;
                System.out.print(Counter.counter + " ");
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                increment();
            }
        }
    }
}
