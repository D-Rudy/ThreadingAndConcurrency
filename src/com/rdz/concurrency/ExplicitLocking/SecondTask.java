package com.rdz.concurrency.ExplicitLocking;

public class SecondTask implements Runnable {
	ResourceOne rOne;
	ResourceTwo rTwo;

	public SecondTask(ResourceOne r1, ResourceTwo r2) {
		this.rOne = r1;
		this.rTwo = r2;
	}

	@Override
	public void run() {
		try {
			rTwo.rTwoLock.lock();
			System.out.println("ResourceTwo est bloqué par: " + Thread.currentThread().getName());

			rTwo.myVar++;
			Thread.sleep(1000);

			rTwo.rTwoLock.unlock();
			System.out.println("Verrou de ResourceTwo déverrouillé par: " + Thread.currentThread().getName());

			rOne.rOneLock.lock();
			System.out.println("ResourceOne est bloqué par: " + Thread.currentThread().getName());

			rOne.myVar--;
			Thread.sleep(1000);

			rOne.rOneLock.unlock();
			System.out.println("Verrou de ResourceOne déverrouillé par: " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
