package com.cy.create;

/**
 * 作为线程任务存在
 */
public class Create02 implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("thread running");
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new Create02());
        thread.run();
    }
}
