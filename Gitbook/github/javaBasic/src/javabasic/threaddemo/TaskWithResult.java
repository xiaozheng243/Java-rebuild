package javabasic.threaddemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用Callable会返回参数
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "Executor " + id;
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(exec.submit(new TaskWithResult(i)));
        }
        exec.shutdown();
        list.forEach(e -> {
            try {
                if (e.isDone()) // 查询future是否已经完成，可不判断，但get方法可能会阻塞
                    System.out.println(e.get());
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
