package com.yida.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = new ThreadPoolExecutor(2, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(200));
        executorService.execute(new MyThread("任务——1"));
        executorService.execute(new MyThread("任务——2"));
        executorService.execute(new MyThread("任务——3"));
        executorService.execute(new MyThread("任务——4"));
    }

    static class MyThread extends Thread {
        private String threadName;

        public MyThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("线程:" + threadName + "执行");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}