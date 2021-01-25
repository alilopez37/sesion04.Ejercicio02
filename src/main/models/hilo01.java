package main.models;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class hilo01 extends Thread{
    private boolean state = true;
    private Semaphore mutex;

    public hilo01(Semaphore mutex){
        this.mutex = mutex;
    }
    @Override
    public void run() {
        while(state) {
            System.out.println("a");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(100)+100);
            } catch (InterruptedException e) {
                state = false;
            }
            mutex.release();
            System.out.println("b");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(100)+100);
            } catch (InterruptedException e) {
                state = false;
            }
        }
    }
}
