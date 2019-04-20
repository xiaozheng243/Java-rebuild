package javabasic.threaddemo;

public class ThreadDemo extends Thread {
    private static int id = 0;
    private final int threadNo = id++;
    private int count = 15;
    @Override
    public void run() {
        while (count-- > 0) {
            System.out.println("Thread" + threadNo + "::" + count);
            Thread.yield();
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new ThreadDemo().start();
        }
    }
}
