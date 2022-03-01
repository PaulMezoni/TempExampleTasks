package multithreading;

public class Ex2 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    static class Thread1 extends Thread {

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                System.out.println(i + "        thread 1");
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            for (var i = 100; i >= 0; i--) {
                System.out.println(i + "        thread 2");
            }
        }
    }
}
