package javabasic.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool会创建需要线程数量的线程，应当尽量使用，当这种方式引发问题时，可以使用FixedThreadPool
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new RunnableDemo());
        }
        exec.shutdown();
    }
}
