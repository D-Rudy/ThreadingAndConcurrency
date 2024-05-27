package com.rdz.concurrency.stampedLock;

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
//			long writeLockTwoStamp = rTwo.rTwoLock.writeLock();
			long writeLockTwoStamp = rTwo.rTwoLock.readLock();
			System.out.println("ResourceTwo est bloqué par: " + Thread.currentThread().getName() + " LockStamp: "
					+ writeLockTwoStamp);
			Thread.sleep(1000);
			rTwo.myVar++;
			rTwo.rTwoLock.unlock(writeLockTwoStamp);
			System.out.println("Verrou de ResourceTwo déverrouillé par: " + Thread.currentThread().getName()
					+ " LockStamp: " + writeLockTwoStamp);

//			long writeLockOneStamp = rOne.rOneLock.writeLock();
			long writeLockOneStamp = rOne.rOneLock.readLock();

			System.out.println("ResourceOne est bloqué par: " + Thread.currentThread().getName() + " LockStamp: "
					+ writeLockOneStamp);
			Thread.sleep(1000);
			rOne.myVar--;

			rOne.rOneLock.unlock(writeLockOneStamp);
			System.out.println("Verrou de ResourceOne déverrouillé par: " + Thread.currentThread().getName()
					+ " LockStamp: " + writeLockOneStamp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
