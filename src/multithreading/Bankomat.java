package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Paul", lock);
        new Employee("Ramon", lock);
        new Employee("Max", lock);
    }

    static class Employee extends Thread {
        String name;
        Lock lock;

        public Employee(String name, Lock lock) {
            this.name = name;
            this.lock = lock;
            this.start();
        }

        @Override
        public void run() {
            System.out.println(name + " waiting...");
            lock.lock();
            System.out.println("Банкоматом пользуется " + name);
            try {
                Thread.sleep(4000);
                System.out.println(name + " завершил");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
