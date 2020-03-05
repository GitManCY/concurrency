package com.cy.lock_category;

public class ChongRuLock {
    public synchronized void a() {
        System.out.println("a");
        b();
    }

    public synchronized void b() {
        System.out.println("b");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ChongRuLock().a();
            }
        }).start();
    }
}
