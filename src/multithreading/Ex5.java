package multithreading;

public class Ex5 {
    public static void main(String[] args) {
        Thread5 thread5 = new Thread5();
    }

    static class Thread5 extends Thread {
        @Override
        public void run() {
            System.out.println(" hello");
        }
    }
}
