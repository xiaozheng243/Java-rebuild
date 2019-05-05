package javabasic.threaddemo;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncDemo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread thread1 = new Thread(demo, "Thread1");
        Thread thread2 = new Thread(demo, "Thread2");
        thread1.start();
        thread2.start();
    }
}

class Demo implements Runnable {
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "::" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }
}