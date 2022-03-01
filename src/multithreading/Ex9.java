package multithreading;

public class Ex9 {

    public static void main(String[] args) {
        Thread th1 = new Thread(new Mobile());
        Thread th2 = new Thread(new Skype());
        Thread th3 = new Thread(new Whatsapp());

        th1.start();
        th2.start();
        th3.start();
    }


    static final Object lock = new Object();

    void mobileCall() {
        synchronized (lock) {
            System.out.println(" 1 mobile call start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 1 mobile call END");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println(" 2 skype call start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 2 skype call END");
        }
    }

    void whatsAppCall() {
        synchronized (lock) {
            System.out.println(" 3 whatsapp call start");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 3 whatsapp call END");
        }
    }

    static class Mobile implements Runnable {
        @Override
        public void run() {
            new Ex9().mobileCall();
        }
    }

    static class Skype implements Runnable {

        @Override
        public void run() {
            new Ex9().skypeCall();
        }
    }

    static class Whatsapp implements Runnable {

        @Override
        public void run() {
            new Ex9().whatsAppCall();
        }
    }

}
