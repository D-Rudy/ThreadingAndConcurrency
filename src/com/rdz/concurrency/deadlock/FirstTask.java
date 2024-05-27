package com.rdz.concurrency.deadlock;

public class FirstTask implements Runnable {

	ResourceOne rOne;
	ResourceTwo rTwo;

	public FirstTask(ResourceOne r1, ResourceTwo r2) {
		this.rOne = r1;
		this.rTwo = r2;
	}

	@Override
	public void run() {
		try {
			synchronized (rOne) {
				System.out.println("ResourceOne est bloqué par: " + Thread.currentThread().getName());

				rOne.myVar++;
				Thread.sleep(1000);
			}
			System.out.println("Verrou de ResourceOne déverrouillé par: " + Thread.currentThread().getName());

			synchronized (rTwo) {
				System.out.println("ResourceTwo est bloqué par: " + Thread.currentThread().getName());

				rOne.myVar--;
				Thread.sleep(1000);
			}

			System.out.println("Verrou de ResourceTwo déverrouillé par: " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
