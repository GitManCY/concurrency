package com.cy.lock;

public class MyAQSLockTest {

    private int value;
    private MyAQSLock lock = new MyAQSLock();

    public int next() {
        lock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {

        MyAQSLockTest m = new MyAQSLockTest();

        new Thread(() -> {
            m.a();
        }).start();

    }
}
