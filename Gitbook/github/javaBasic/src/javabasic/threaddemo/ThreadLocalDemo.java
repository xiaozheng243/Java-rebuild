package javabasic.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Accessor implements Runnable {

    private final int id;

    Accessor(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

        }
    }

    @Override
    public String toString() {
        return id + "::";
    }
}


public class ThreadLocalDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Accessor(i));
        }
    }
}
