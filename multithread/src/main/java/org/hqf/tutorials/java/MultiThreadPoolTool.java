package org.hqf.tutorials.java;

import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.function.Consumer;

public class MultiThreadPoolTool {
    // 创建固定大小的线程池
    public static ExecutorService createFixedThreadPool(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                Executors.defaultThreadFactory(),
                new CallerRunsPolicy()
        );
        return executor;
    }

    // 创建可缓存的线程池
    public static ExecutorService createCachedThreadPool() {
        // 默认的CachedThreadPool会使用SynchronousQueue，允许创建无限数量的线程
        return Executors.newCachedThreadPool();
    }

    // 创建单线程的线程池
    public static ExecutorService createSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    // 创建定时任务的线程池
    public static ScheduledExecutorService createScheduledThreadPool(int corePoolSize) {
        return Executors.newScheduledThreadPool(corePoolSize);
    }

    // 提交任务到线程池
    public static void executeTask(ExecutorService executor, Runnable task) {
        executor.execute(task);
    }

    // 关闭线程池
    public static void shutdown(ExecutorService executor) {
        executor.shutdown();
    }

    // 优雅地关闭线程池，等待所有任务完成
    public static void gracefulShutdown(ExecutorService executor, long timeout, TimeUnit unit) {
        executor.shutdown(); // 开始关闭线程池，并等待已提交的任务完成
        try {
            if (!executor.awaitTermination(timeout, unit)) {
                executor.shutdownNow(); // 如果超时，则尝试强制关闭所有正在执行的任务
            }
        } catch (InterruptedException e) {
            executor.shutdownNow(); // 重新尝试关闭线程池，如果线程池正在关闭时中断
            Thread.currentThread().interrupt(); // 保留中断状态
        }
    }

    // 线程任务的示例
    public static class MyTask implements Runnable {
        private final String taskName;

        public MyTask(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            System.out.println("Executing task: " + taskName);
            // 模拟任务执行时间
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    // 测试多线程池工具类
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = createFixedThreadPool(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 150; i++) {
            executeTask(fixedThreadPool, new MyTask("Task-" + i));
        }
        gracefulShutdown(fixedThreadPool, 12, TimeUnit.SECONDS);
    }
}