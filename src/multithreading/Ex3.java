package multithreading;

public class Ex3 implements Runnable {
    public static void main(String[] args) {
        Thread thread3 = new Thread(new Thread3());
        Thread thread4 = new Thread(new Thread4());
        thread3.start();
        thread4.start();

        Thread ex3 = new Thread(new Ex3());
        ex3.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(i + " thread 3");
        }
    }

    static class Thread3 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 500; i++) {
                System.out.println(i + "        thread 1");
            }
        }
    }

    static class Thread4 implements Runnable {

        @Override
        public void run() {
            for (int i = 500; i >= 0; i--) {
                System.out.println(i + "        thread 2");
            }
        }
    }
}
