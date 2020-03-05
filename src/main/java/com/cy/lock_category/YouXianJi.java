package com.cy.lock_category;


public class YouXianJi implements Runnable{
    public static void main(String[] args) {
        Thread thread1 = new Thread(new YouXianJi());
        Thread thread2 = new Thread(new YouXianJi());

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }
}
