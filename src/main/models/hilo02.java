package main.models;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class hilo02 extends Thread{
    private boolean state = true;
    private Semaphore mutex;

    public hilo02(Semaphore mutex){
        this.mutex = mutex;
    }
    @Override
    public void run() {
        while (state) {
            System.out.println("c");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(100)+100);
            } catch (InterruptedException e) {
                state = false;
            }
            try {
                mutex.acquire();
            } catch (InterruptedException e) {
                state = false;
            }
            System.out.println("d");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(100)+100);
            } catch (InterruptedException e) {
                state = false;
            }
        }
    }
}
