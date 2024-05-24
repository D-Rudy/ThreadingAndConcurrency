package com.rdz.concurrency;

public class ThreadLifeCycle {

	public static class Walk implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// System.out.println("Je marche..., état du thread: " +
				// Thread.currentThread().getState());
				System.out.println("Je marche..., état du thread: " + Thread.currentThread().isAlive());
			}
		}
	}

	public static class ChewGum implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Je mâche un chewing-gum");
			}
		}
	}

	public static void threadJoin() {

		Thread walkThread = new Thread(new Walk());
		Thread chewThread = new Thread(new ChewGum());

		try {
			walkThread.start();
			walkThread.join(5000);
			// Le paramètre permet de laisser un delai afin que le second thread se lance
			chewThread.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void ThreadStates() {

		Thread walkThread = new Thread(new Walk());
		System.out.println("Etat de walkThread après init: " + walkThread.getState()); // NEW
		System.out.println("Etat de main thread après init: " + Thread.currentThread().getState()); // RUNNABLE

		try {
			walkThread.start();
			System.out.println("Etat de walkThread après démarrage: " + walkThread.getState());// RUNNABLE
			System.out
					.println("Etat de main thread après démarrage de walkThread: " + Thread.currentThread().getState());// RUNNABLE

			Thread.sleep(1000);
			walkThread.join(5000);

			System.out.println("Etat de walkThread après jointure: " + walkThread.getState());// TIMED_WAITING
			System.out
					.println("Etat de main thread après jointure de walkThread: " + Thread.currentThread().getState());// RUNNABLE

			System.out.println("Veille de main thread pendant 20 sec: ");
			Thread.sleep(20000);

			System.out.println("Etat de walkThread à la fin: " + walkThread.getState());// TERMINATED
			System.out.println("Etat de main thread à la fin de walkThread: " + Thread.currentThread().getState());// RUNNABLE
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Thread walkThread = new Thread(new Walk());
		System.out.println("Etat isAlive de walkThread après init: " + walkThread.isAlive());// False
		try {
			walkThread.start();
			System.out.println("Etat isAlive de walkThread après démarrage: " + walkThread.isAlive());// True

			walkThread.join(5000);
			System.out.println("Etat isAlive de walkThread après jointure: " + walkThread.isAlive());// False //True si temporisé

			Thread.sleep(11000);
			System.out.println("Etat isAlive de walkThread a la fin: " + walkThread.isAlive());// False
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
