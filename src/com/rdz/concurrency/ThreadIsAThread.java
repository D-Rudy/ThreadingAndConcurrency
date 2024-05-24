package com.rdz.concurrency;

public class ThreadIsAThread extends Thread {

	@Override
	public void run() {
		System.out.println("Ce thread est en cours d'execution...");
	}

}
