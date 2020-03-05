package com.cy.lock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReadWriteLock();
        lock.put("key1", "value1");

        new Thread((() -> {
            lock.get("key1");
        })).start();
        new Thread((() -> {
            lock.get("key1");
        })).start();
//        new Thread((() -> {
//            lock.put("key1","value3");
//        })).start();
//        new Thread((() -> {
//            lock.put("key2","value3");
//        })).start();
//        new Thread((() -> {
//            lock.put("key3","value3");
//        })).start();
    }
}
