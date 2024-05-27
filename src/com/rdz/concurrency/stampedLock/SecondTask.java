package com.rdz.concurrency.stampedLock;

import java.util.concurrent.TimeUnit;

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
//			boolean rTwoLockAquired = rTwo.rTwoLock.tryLock();
			boolean rTwoLockAquired = rTwo.rTwoLock.tryLock(10, TimeUnit.SECONDS);

			if (rTwoLockAquired) {
				System.out.println("ResourceTwo est bloqué par: " + Thread.currentThread().getName());
				rTwo.myVar++;
				Thread.sleep(5000);
				rTwo.rTwoLock.unlock();
				System.out.println("Verrou de ResourceTwo déverrouillé par: " + Thread.currentThread().getName());
			}

			boolean rOneLockAquired = rOne.rOneLock.tryLock(10, TimeUnit.SECONDS);

			if (rOneLockAquired) {
				System.out.println("ResourceOne est bloqué par: " + Thread.currentThread().getName());
				rOne.myVar--;
				Thread.sleep(1000);
				rOne.rOneLock.unlock();
				System.out.println("Verrou de ResourceOne déverrouillé par: " + Thread.currentThread().getName());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
