package com.cy.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Create04 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("计算中");
        Thread.sleep(2000);
        return 3;
    }

    public static void main(String[] args) throws Exception {
        Create04 create04 = new Create04();
        FutureTask<Integer> task = new FutureTask<>(create04);
        new Thread(task).start();
        System.out.println("我先干别的");
        Integer integer = task.get();
        System.out.println(integer);
    }
}
