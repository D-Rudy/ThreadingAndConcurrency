package com.rdz.concurrency;

public class Synchronization implements Runnable {

	private static int myNum;
	private static final int NUM_ITERATIONS = 100000;

	public static class CommonCounter {
		public static synchronized void incrementCounter() {
			myNum++;
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < NUM_ITERATIONS; i++) {
			CommonCounter.incrementCounter();
		}
	}

	public static void main(String[] args) {
		Thread threadOne = new Thread(new Synchronization());
		Thread threadTwo = new Thread(new Synchronization());

		System.out.println("Valeur de départ de myNum: " + myNum);

		try {
			threadOne.start();
			threadTwo.start();

			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Valeur de finale de myNum: " + myNum);
	}

}
