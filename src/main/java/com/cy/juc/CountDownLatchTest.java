package com.cy.juc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 计数
 */
public class CountDownLatchTest {

	private int[] nums;

	public CountDownLatchTest(int line) {
		nums = new int[line];
	}

	public void calc(String line, int index, CountDownLatch latch) {
		String[] nus = line.split(",");
		int total = 0;
		for (String num : nus) {
			total += Integer.parseInt(num);
		}
		nums[index] = total;
		System.out.println(Thread.currentThread().getName()  + line + + total);
		latch.countDown();
	}

	public void sum() {
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		System.out.println( total);
	}

	public static void main(String[] args) {

		List<String> contents = readFile();
		int lineCount = contents.size();
		
		CountDownLatch latch = new CountDownLatch(lineCount);

		CountDownLatchTest d = new CountDownLatchTest(lineCount);
		for (int i = 0; i < lineCount; i++) {
			final int j = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					d.calc(contents.get(j), j, latch);
				}
			}).start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		d.sum();
	}

	private static List<String> readFile() {
		List<String> contents = new ArrayList<>();
		String line = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("/Users/a123/Desktop/my/Idea_workspace/并发编程/nums"));
			while ((line = br.readLine()) != null) {
				contents.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return contents;
	}

}
