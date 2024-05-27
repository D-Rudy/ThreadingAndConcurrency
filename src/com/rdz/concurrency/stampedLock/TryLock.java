package com.rdz.concurrency.stampedLock;


public class TryLock {
	public static void main(String[] args) throws InterruptedException{
		ResourceOne r1 = new ResourceOne();
		ResourceTwo r2 = new ResourceTwo();

		Thread firstTaskThread = new Thread(new FirstTask(r1, r2), "firstTaskThread");
		Thread secondTaskThread = new Thread(new SecondTask(r1, r2), "secondTaskThread");

		System.out.println("Demarrage des deux threads");

		firstTaskThread.start();
		secondTaskThread.start();

		firstTaskThread.join();
		secondTaskThread.join();

		System.out.println("Les deux threads sont terminés");
	}

}
