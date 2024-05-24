package com.rdz.concurrency;

public class ThreadMethods {

	public static class Walk implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Je marche");
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

	public static void main(String[] args) {
		
		Thread walkThread = new Thread(new Walk());
		Thread chewGum = new Thread(new ChewGum());

		walkThread.start();
		chewGum.start();
		
		System.out.println("\nId de walkThread: " + walkThread.getId());
		System.out.println("Id de chewGum: " + chewGum.getId());
		System.out.println("Id de main: " + Thread.currentThread().getId());

		System.out.println("\nNom de walkThread: " + walkThread.getName());
		System.out.println("Nom de chewGum: " + chewGum.getName());
		System.out.println("Nom de main: " + Thread.currentThread().getName());
		
		System.out.println("\nGroupe thread de walkThread: " + walkThread.getThreadGroup());
		System.out.println("Groupe thread de chewGum: " + chewGum.getThreadGroup());
		System.out.println("Groupe thread de main: " + Thread.currentThread().getThreadGroup());
		
		System.out.println("\nPriorité de walkThread: " + walkThread.getPriority());
		System.out.println("Priorité thread de chewGum: " + chewGum.getPriority());
		System.out.println("Priorité thread de main: " + Thread.currentThread().getPriority());
		
		System.out.println("\nThread Actifs: " + Thread.activeCount());
		
		System.out.println("\n\n");
	}

}
