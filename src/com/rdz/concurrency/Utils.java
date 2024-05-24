package com.rdz.concurrency;

public class Utils {

	public static void RunnableVsThread() {

		System.out.println("-----RUNNABLE-----");

		Thread runnableThread = new Thread(new RunnableThread());

		runnableThread.start();

		System.out.println("runnableThread est Runnable: " + (runnableThread instanceof Runnable));
		System.out.println("runnableThread est un Thread: " + (runnableThread instanceof Thread));
		System.out.println("runnableThread est un objet: " + (runnableThread instanceof Object));

		System.out.println("\n\n-----THREAD-----");

		ThreadIsAThread thread = new ThreadIsAThread();
		// Favoriser plutot l'instanciation avec Runnable car java n'autorise pas
		// l'héritage multiple
		thread.start();

		System.out.println("thread est Runnable: " + (thread instanceof Runnable));
		System.out.println("thread est un Thread: " + (thread instanceof Thread));
		System.out.println("thread est un objet: " + (thread instanceof Object));
	}
}
