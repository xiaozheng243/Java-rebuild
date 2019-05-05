package javabasic.practiceDemo;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class FixedDemo implements Callable<String> {

    private static int count = 5;

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + "::" + count--;
    }
}


public class FixedExecutorDemo {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    public static void main(String[] args) {
        List<Future<String>> list = new ArrayList<>();
        FixedDemo fiexedDemo = new FixedDemo();
        for (int i = 0; i < 5; i++) {
            list.add(executorService.submit(fiexedDemo));
        }
        list.forEach(e -> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
