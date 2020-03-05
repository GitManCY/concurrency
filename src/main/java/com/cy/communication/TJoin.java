package com.cy.communication;


public class TJoin {
    public void a(Thread joinThread) {

        System.out.println("a start");
        joinThread.start();
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a finish");
    }

    public void b() {
        System.out.println("加塞线程 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加塞线程 finish");
    }

    public static void main(String[] args) {
        TJoin tJoin = new TJoin();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                tJoin.b();
            }
        });
        new Thread(() -> {
            tJoin.a(thread);
        }).start();
    }
}
