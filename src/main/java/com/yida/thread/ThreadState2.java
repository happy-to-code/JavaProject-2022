package com.yida.thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadState2 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                LockSupport.park();
            }
        });

        thread2.start();
        Thread.sleep(500);
        System.out.println("1--->" + thread2.getState());
        LockSupport.unpark(thread2);
        Thread.sleep(500);
        System.out.println("2--->" + thread2.getState());
    }


}
