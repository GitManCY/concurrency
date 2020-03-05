package com.cy.create;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Create07 {
    @Async
    public void a() throws InterruptedException {
        while (true){
            System.out.println("a");
            Thread.sleep(2000);
        }

    }
    @Async
    public void b() throws InterruptedException {
        while (true){
            System.out.println("b");
            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Create07 bean = ac.getBean(Create07.class);
        bean.a();
        bean.b();
    }
}
