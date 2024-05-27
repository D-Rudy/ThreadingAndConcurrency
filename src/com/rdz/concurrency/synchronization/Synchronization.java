package com.rdz.concurrency.synchronization;

public class Synchronization {

	private static final int NUM_ITERATIONS = 10000;

	public static void main(String[] args) {

		CommonCounter commonCounterOne = new CommonCounter();
		CommonCounter commonCounterTwo = new CommonCounter();

		Thread threadOne = new Thread(new CounterIncrementor(commonCounterOne, NUM_ITERATIONS));
		Thread threadTwo = new Thread(new CounterIncrementor(commonCounterTwo, NUM_ITERATIONS));
		Thread threadThree = new Thread(new CounterIncrementor(commonCounterTwo, NUM_ITERATIONS));

		System.out.println("Valeur de début du compteur 1: \n    Valeur 1: " + commonCounterOne.getFirstNum()
				+ "\n    Valeur 2: " + commonCounterOne.getSecondNum());
		System.out.println("Valeur de début du compteur 2: \n    Valeur 1: " + commonCounterTwo.getFirstNum()
				+ "\n    Valeur 2: " + commonCounterTwo.getSecondNum());
		try {
			threadOne.start();
			threadTwo.start();
			threadThree.start();

			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\n*****************************\n");
		System.out.println("Valeur finale du compteur 1: \n    Valeur 1: " + commonCounterOne.getFirstNum()
				+ "\n    Valeur 2: " + commonCounterOne.getSecondNum());
		System.out.println("Valeur finale du compteur 2: \n    Valeur 1: " + commonCounterTwo.getFirstNum()
				+ "\n    Valeur 2: " + commonCounterTwo.getSecondNum());
	}
}
