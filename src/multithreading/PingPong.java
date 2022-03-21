package multithreading;

public class PingPong {
    public static void main(String[] args) {

        Ping ping = new Ping();
        Pong pong = new Pong();
        ping.start();
        pong.start();

    }

    static class Ping extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("ping");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Pong extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("pong");
                try {
                    Thread.sleep(1300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
