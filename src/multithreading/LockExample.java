package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) {
        Thread th1 = new Thread(new Mobile());
        Thread th2 = new Thread(new Skype());
        Thread th3 = new Thread(new Whatsapp());

        th1.start();
        th2.start();
        th3.start();
    }


    static final Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        System.out.println(" 1 mobile call start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(" 1 mobile call END");
    }

    void skypeCall() {
        lock.lock();
        System.out.println(" 2 skype call start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(" 2 skype call END");

    }

    void whatsAppCall() {
        lock.lock();
        System.out.println(" 3 whatsapp call start");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(" 3 whatsapp call END");
        }
    }

    static class Mobile implements Runnable {
        @Override
        public void run() {
            new LockExample().mobileCall();
        }
    }

    static class Skype implements Runnable {

        @Override
        public void run() {
            new LockExample().skypeCall();
        }
    }

    static class Whatsapp implements Runnable {

        @Override
        public void run() {
            new LockExample().whatsAppCall();
        }
    }

}


