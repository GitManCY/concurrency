package com.cy.create;

public class Create01 extends Thread {

    public Create01(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(this.getName() + "线程执行了");
        }
    }

    public static void main(String[] args) {
        Create01 create01 = new Create01("first");   //Thread-0线程执行了
        Create01 create02 = new Create01("second");   //Thread-1线程执行了
        create01.start();
        create02.start();
    }
}
