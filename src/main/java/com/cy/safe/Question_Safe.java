package com.cy.safe;

public class Question_Safe {

    private  int value = 0;

    public  synchronized int add() {
        return value++;
    }

    public static void main(String[] args) {
        Question_Safe question_safe = new Question_Safe();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ":" + question_safe.add());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                        System.out.println(Thread.currentThread().getName() + ":" + question_safe.add());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ":" + question_safe.add());
                }
            }
        }).start();
    }
}
