package multithreading;

public class WaitNotifyEx {
    public static void main(String[] args) {

        Market market = new Market();

        Thread th1 = new Thread(new Producer(market));
        Thread th2 = new Thread(new Consumer(market));
        th2.start();
        th1.start();

    }

    static class Market {
        private int breadCount = 0;

        public synchronized void getBread() {
            while (breadCount < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount--;
            System.out.println("Потребитель купил 1 хлеб");
            System.out.println("Количество хлеба в магазине = " + breadCount);
            notify();
        }

        public synchronized void putBread() {
            while (breadCount > 6) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount++;
            System.out.println("the manufacturer added 1 bread to the display case");
            System.out.println("count bread = " + breadCount);
            notify();
        }
    }

    static class Producer implements Runnable {
        Market market;

        public Producer(Market market) {
            this.market = market;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                market.putBread();
            }
        }
    }

    static class Consumer implements Runnable {
        Market market;

        public Consumer(Market market) {
            this.market = market;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                market.getBread();
            }
        }
    }

}
