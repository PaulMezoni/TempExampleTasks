package multithreading;

public class DeadLockEx extends Throwable {
    public static void main(String[] args) {
        var thread1 = new Thread1();
        var thread2 = new Thread2();
        thread1.start();
        thread2.start();
        System.out.println(method());


        var runtimeException1 = new RuntimeException("Ex1");
        var runtimeException2 = new RuntimeException("Ex2");
        runtimeException1.addSuppressed(runtimeException2);

        throw runtimeException2;

    }

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static int method() {
// при выходе из блока try закрываются ресурсы в tryWithResources

        try { // секция небезопасного выполнения
//            System.out.println("try");
            throw new Exception();
//            return 1;
        } catch (Exception e) { //секция обработки
//            System.out.println(e + " catch");
            return 2;
        } finally {
//            System.out.println("fin");
            return 3;
        }
    }

    static class Thread1 extends Thread {


        @Override
        public void run() {
            System.out.println(getClass().toString() + " попытка захватить монитор объекта lock1");
            synchronized (lock1) {
                System.out.println(getClass().toString() + " монитор объекта lock1 захвачен");
                System.out.println(getClass().toString() + " попытка захватить монитор объекта lock2");
                synchronized (lock2) {
                    System.out.println(" мониторы обхектов lock1 and lock2 захвачены ");
                }
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            System.out.println("Thread 2 попытка захватить монитор объекта lock2");
            synchronized (lock2) {
                System.out.println("Thread 2  монитор объекта lock2 захвачен");
                System.out.println(" попытка захватить монитор объекта lock1");
                synchronized (lock1) {
                    System.out.println(" мониторы обхектов lock1 and lock2 захвачены ");
                }
            }
        }
    }
}
