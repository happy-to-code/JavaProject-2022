package com.yida.thread;

public class ThreadState extends Thread {
    @Override
    public void run() {
        System.out.println(" ======= ");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadState ts = new ThreadState();
        System.out.println("1ts.getState() = " + ts.getState());
        ts.start();
        System.out.println("2ts.getState() = " + ts.getState());

        final byte[] lock = new byte[0];
        new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                }
            }
        });
        thread2.start();// 调用此方法后是可运行状态
        System.out.println("1111thread2.getState():::"+thread2.getState());
        Thread.sleep(1000);
        System.out.println("2222thread2.getState():::"+thread2.getState());
    }


}
