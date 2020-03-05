package com.cy.communication;

public class TNotify {

    private volatile int signal;

    public void set(int value) {
        this.signal = value;
    }

    public int get() {
        return signal;
    }

    public static void main(String[] args) {
        TNotify tNotify = new TNotify();
        new Thread(() -> {
            synchronized (tNotify) {
                System.out.println("修改状态的线程执行");
                try {
                    Thread.sleep(5000);
                    tNotify.set(1);
                    tNotify.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            //当signal为1时 执行代码
            synchronized (tNotify) {
                while (tNotify.get() != 1) {
                    try {
                        Thread.sleep(1000);
                        tNotify.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //当信号为1 执行代码
                System.out.println("模拟代码执行");
            }
        }).start();
    }
}
