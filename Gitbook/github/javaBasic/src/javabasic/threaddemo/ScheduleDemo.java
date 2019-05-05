package javabasic.threaddemo;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class SomeThingDemo {
    private static int count = 10;

    public int getCount() {
        return count--;
    }

}

public class ScheduleDemo implements Runnable {

    private SomeThingDemo someThingDemo = new SomeThingDemo();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "延迟1s执行::" + someThingDemo.getCount());
    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new ScheduleDemo(), 2, 1, TimeUnit.SECONDS);
    }
}
