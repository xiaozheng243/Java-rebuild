package javabasic.threaddemo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SleepDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(() -> {
                Random random = new Random();
                int second = random.nextInt(5);
                try {
                    System.out.println(Thread.currentThread() + "::" + second);
                    Thread.sleep(second * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }
}
