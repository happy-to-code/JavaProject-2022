package com.yida.thread;

public class ThreadState3 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();
        Thread.sleep(500);
        System.out.println(thread3.getState());
    }
}
