package com.cy.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyChongRuLock {
	
	Lock lock = new ReentrantLock();
	
	public void a() {
		lock.lock();
		System.out.println("a");
		b();
		lock.unlock();
	}
	
	public void b() {
		lock.lock();
		System.out.println("b");
		c();
		lock.unlock();
	}
	
	public void c() {
		lock.lock();
		System.out.println("c");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		MyChongRuLock d = new MyChongRuLock();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				d.a();
			}
		}).start();
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				d.b();
//			}
//		}).start();
		
	}

}
