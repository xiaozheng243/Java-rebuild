package javabasic.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程运行,比如处理文件系统
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            exec.execute(new RunnableDemo());
        }
        exec.shutdown();
    }
}
