package com.rdz.concurrency;

public class DeamonsAndThreadGroups {

	public static class ChewGum implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String threadGroup = Thread.currentThread().getThreadGroup().getName();
				int activeThreads = Thread.activeCount();

				System.out.println("Je mache un chewing-gum... " + " Mon groupe est: " + threadGroup
						+ " qui a un nombre de fils actif de: " + activeThreads);
			}
		}
	}

	public static class Walk implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String threadGroup = Thread.currentThread().getThreadGroup().getName();
				int activeThreads = Thread.activeCount();

				System.out.println("Je marche... " + " Mon groupe est: " + threadGroup
						+ " qui a un nombre de fils actif de: " + activeThreads);
			}
		}
	}

	public static void main(String[] args) {

		ThreadGroup groupOne = new ThreadGroup("Groupe 1");
		ThreadGroup groupTwo = new ThreadGroup("Groupe2");

		Thread walkThread1 = new Thread(groupOne, new Walk());
		Thread walkThread2 = new Thread(groupTwo, new Walk());
		Thread walkThread3 = new Thread(groupTwo, new Walk());

		Thread chewThread1 = new Thread(groupOne, new ChewGum());
		Thread chewThread2 = new Thread(groupTwo, new ChewGum());

		walkThread1.start();
		walkThread2.start();
		walkThread3.start();
		chewThread1.start();
		chewThread2.start();

		System.out.println("\n#Threads actif pour main: " + Thread.activeCount());
		System.out.println("#Threads actif pour Groupe 1: " + groupOne.activeCount());
		System.out.println("#Threads actif pour Groupe 2: " + groupTwo.activeCount());

		System.out.println("\n\n");

	}
}
