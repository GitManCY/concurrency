package com.cy.juc.MyFuture;

public class Demo {

	/**
	 * callable 和 runnable的区别
	 *
	 * runnable 是被线程调用的 在run方法是异步执行的
	 *
	 * callable 的call方法 不是异步执行的 是由future的run方法调用的
	 * @param args
	 */

	public static void main(String[] args) {

		ProductFactory pf = new ProductFactory();

		// 下单，交钱
		Future f = pf.createProduct("蛋糕");

		System.out.println("我去上班了，下了班我来取蛋糕...");

		// 拿着订单获取产品
		System.out.println("我拿着蛋糕回家." + f.get());
	}

}

