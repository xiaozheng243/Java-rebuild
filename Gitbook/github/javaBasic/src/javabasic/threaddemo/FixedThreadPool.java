package javabasic.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 指定线程数运行
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);// 指定线程数
        for (int i = 0; i < 5; i++)
            exec.execute(new RunnableDemo());
        exec.shutdown();
    }
}
