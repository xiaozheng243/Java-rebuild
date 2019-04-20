package javabasic.threaddemo;

public class RunnableDemo implements Runnable {
    private static int baseNo = 0;
    private final int threadNo = baseNo++;
    private int totalCount = 15;
//    public static void main(String[] args) {
//        for (int i = 0; i < 4; i++)
//            new Thread(new RunnableDemo()).start();
//    }
    @Override
    public void run() {
        while (totalCount-- > 0) {
            System.out.println("Thread" + threadNo + "::" + totalCount);
            Thread.yield();
        }
    }
}
