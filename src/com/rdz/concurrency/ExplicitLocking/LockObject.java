package com.rdz.concurrency.ExplicitLocking;

import com.rdz.concurrency.deadlock.FirstTask;
import com.rdz.concurrency.deadlock.ResourceOne;
import com.rdz.concurrency.deadlock.ResourceTwo;
import com.rdz.concurrency.deadlock.SecondTask;

public class LockObject {
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
