package com.cy.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyAQSLock implements Lock {

    private Helper helper = new Helper();


    private class Helper extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            //第一个线程进来 可以拿到锁 返回true
            //第二个线程进来 拿不到锁 返回false
            //如何判断是第几个线程进来
            int state = getState();
            Thread thread = Thread.currentThread();

            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(thread);
                    return true;
                }
            } else if (getExclusiveOwnerThread() == thread) {
                setState(state + 1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            //锁的获取和释放肯定是一一对应的，那么调用此方法的线程一定是当前的线程
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }
            int state = getState() - arg;

            boolean flag = false;
            if (getState() == 0) {
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);
            return flag;
        }

        public Condition newConditoion() {
            return new ConditionObject();
        }
    }


    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newConditoion();
    }


}
