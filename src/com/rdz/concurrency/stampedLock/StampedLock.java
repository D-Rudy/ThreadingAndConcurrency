package com.rdz.concurrency.stampedLock;

public class StampedLock {
	public static void main(String[] args) throws InterruptedException {
		ResourceOne r1 = new ResourceOne();
		ResourceTwo r2 = new ResourceTwo();

		Thread firstTaskThread = new Thread(new FirstTask(r1, r2), "firstTaskThread");
		Thread secondTaskThread = new Thread(new SecondTask(r1, r2), "secondTaskThread");
		Thread anotherSecondTaskThread = new Thread(new SecondTask(r1, r2), "anotherSecondTaskThread");

		System.out.println("Demarrage des deux threads");

		firstTaskThread.start();
		secondTaskThread.start();
		anotherSecondTaskThread.start();

		firstTaskThread.join();
		secondTaskThread.join();
		anotherSecondTaskThread.join();

		System.out.println("Les threads sont terminés");
		System.out.println("Valeur de fin des ressources: " + r1.myVar + "; " + r2.myVar);
	}

}
