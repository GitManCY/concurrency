package com.cy.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("正在计算结果");
                Thread.sleep(3000);
                return 1;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(callable);
        new Thread(task).start();
        System.out.println("干点别的");

        Integer result = task.get();
        System.out.println(result);
    }
}
