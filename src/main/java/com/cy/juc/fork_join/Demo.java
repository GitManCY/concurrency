package com.cy.juc.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Demo extends RecursiveTask<Integer> {
    private int begin;
    private int end;

    public Demo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //计算
        if (end - begin < 2) {
            for (int i = begin; i <= end; i++) {
                sum += i;
            }
        } else {
            //拆分
            Demo demo1 = new Demo(begin, (begin + end) / 2);
            Demo demo2 = new Demo((begin + end) / 2 + 1, end);
            demo1.fork();
            demo2.fork();
            Integer a = demo1.join();
            Integer b = demo2.join();
            sum = a + b;

        }
        return sum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(5);
        Future<Integer> future = pool.submit(new Demo(1,10000000));
        System.out.println("计算的值为:" + future.get());


    }
}
