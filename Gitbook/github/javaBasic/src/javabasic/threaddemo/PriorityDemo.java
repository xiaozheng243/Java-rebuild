package javabasic.threaddemo;

public class PriorityDemo implements Runnable {
    private static int count = 15;
    private static int id = 0;
    private final int threadId = id++;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new PriorityDemo());
        Thread thread2 = new Thread(new PriorityDemo());
        Thread thread3 = new Thread(new PriorityDemo());
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread3.start();
        thread2.start();
        thread1.start();
    }
    @Override
    public void run() {
        while (count-- > 0) {
            System.out.println("Thread" + threadId + "::" + count);
            Thread.yield();
        }

    }
}
