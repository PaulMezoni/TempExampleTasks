package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3);


    public static void main(String[] args) throws InterruptedException {

        new Friend("Paul", countDownLatch);
        new Friend("Paulita", countDownLatch);
        new Friend("Max", countDownLatch);
        new Friend("Ramon", countDownLatch);

        marketStaffIsOnPlace();
        everyThingIsReady();
        openMarket();
        System.out.println("sleep");
        Thread.sleep(5000);
    }

    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void everyThingIsReady() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Everything is ready");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Market is open");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    static class Friend extends Thread {
        private final String name;
        private final CountDownLatch countDownLatch;

        public Friend(String name, CountDownLatch countDownLatch) {
            this.name = name;
            this.countDownLatch = countDownLatch;
            this.start();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                countDownLatch.await();
                System.out.println(name + " приступил(а) к закупкам ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
