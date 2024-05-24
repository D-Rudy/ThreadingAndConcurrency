package com.rdz.concurrency;

public class Main {

	public static void main(String[] args) {

		Thread thread1 = new Thread(new MyThread(), "Thread 0");
		Thread thread2 = new Thread(new MyThread());

		thread2.setName("Thread 1");

		thread1.start();// Thread-0
		thread2.start();// Thread-1

		// thread1.start();
		// Lance une Exception

		// Pour le relancer, utiliser run(), qui relancera l'instance de thread1
		// S'execute sur le thread courant: main

		// thread1.run();//main
	}
}
