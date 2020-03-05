package com.cy.lock_category;

import java.util.Random;

/**
 * 多个线程执行完毕之后 打印一句话 结束
 */
public class ZiXuanLock {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            }
        }).start();
        int i = Thread.activeCount();
        while (i != 1) {
            //自旋
        }
        System.out.println("所有线程执行完毕");
    }

}
