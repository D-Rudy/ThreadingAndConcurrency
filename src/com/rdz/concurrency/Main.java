package com.rdz.concurrency;

public class Main {

	public static void main(String[] args) {
		// Créer une instance de MyThread
		Thread thread1 = new Thread(new MyThread());

		thread1.start();

		System.out.println("Est ce que thread1 est Runnable? " + (thread1 instanceof Runnable));
		System.out.println("Est ce que thread1 est un Thread? " + (thread1 instanceof Thread));
		System.out.println("Est ce que thread1 est un Thread? " + (thread1 instanceof Object));

	}
}
