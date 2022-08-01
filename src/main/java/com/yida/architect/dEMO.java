package com.yida.architect;

public class dEMO {
    public static void main(String[] args) throws InterruptedException {
        final byte[] lock = new byte[0];
        new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
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
                synchronized (lock){
                }
            }
        });
        thread2.start();
        Thread.sleep(1000);
        System.out.println(thread2.getState());
    }
}



