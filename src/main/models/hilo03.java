package main.models;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class hilo03 extends Thread{
    private boolean state = true;
    private Semaphore mutex;

    public hilo03(Semaphore mutex){
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while(state) {
            System.out.println("e");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(100)+100);
            } catch (InterruptedException e) {
                state = false;
            }
            mutex.release();
            System.out.println("f");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(100)+100);
            } catch (InterruptedException e) {
                state = false;
            }
        }
    }
}
