package com.yida.thread;


import java.util.concurrent.*;

public class MultiThreadTest {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world !" + Thread.currentThread().getId());
            }
        });
        System.out.println(" ===> main Thread! ");
    }
}
