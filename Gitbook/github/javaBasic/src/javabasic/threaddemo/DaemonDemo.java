package javabasic.threaddemo;

public class DaemonDemo implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new DaemonDemo());
            thread.setDaemon(true);
            thread.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread");
            Thread.yield();
        }
    }
}
