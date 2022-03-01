package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new Person("Paul", semaphore);
        new Person("Paulita", semaphore);
        new Person("Max", semaphore);
        new Person("Ramon", semaphore);

    }

    static class Person extends Thread {
        private final String name;
        private final Semaphore semaphore;

        public Person(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
            this.start();
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " ждет...");
                semaphore.acquire();
                System.out.println("    Телефон занял    " + name);
                sleep(5000);
                System.out.println(name + " закончил говорить по телефону");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
