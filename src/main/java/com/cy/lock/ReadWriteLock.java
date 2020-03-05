package com.cy.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    private Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public Object get(String key) {
        readLock.lock();
        System.out.println("读:" + Thread.currentThread().getName());
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        } finally {
            readLock.unlock();
            System.out.println("读完了:" + Thread.currentThread().getName());
        }
    }

    public Object put(String key, Object object) {
        writeLock.lock();
        System.out.println("写:" + Thread.currentThread().getName());
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.put(key, object);
        } finally {
            writeLock.unlock();
            System.out.println("写完了:" + Thread.currentThread().getName());
        }
    }
}
