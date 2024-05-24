package com.rdz.concurrency;

public class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " : " + i);
		}
	}

}
