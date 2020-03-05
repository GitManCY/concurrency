package com.cy.create;


public class Create03 {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("thread run");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable run");
            }
        }) {
            public void run() {
                System.out.println("runnable2 run");
            }
        }.start();
    }
}
