package multithreading;

import java.util.HashMap;
import java.util.Map;

public class VolatileEx extends Thread {
    volatile boolean b = true;
    long counter = 0;
    Map map = new HashMap(10);

    @Override
    public void run() {
        while (b) {
            counter++;
        }
        System.out.println("Loop is finished " + counter);
    }

    public static void main(String[] args) throws InterruptedException {


        VolatileEx thread = new VolatileEx();
        thread.start();
        Thread.sleep(1000);
        System.out.println("After 3 sec it is time to wake up! ");
        thread.b = false;
        thread.join();
        System.out.println("END");


    }




}
