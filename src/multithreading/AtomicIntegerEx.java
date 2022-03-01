package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {
    //    static volatile int count = 0;
    static AtomicInteger count = new AtomicInteger(0);

    public static void increment() {
//        count++;
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Run1();
        Thread thread2 = new Run1();

        thread1.join();
        thread2.join();

        thread1.start();
        thread2.start();

        System.out.println(count);
    }

    static class Run1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 2_000; i++) {
                AtomicIntegerEx.increment();
            }
        }
    }
}
