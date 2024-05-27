package com.rdz.concurrency.synchronization;

public class CommonCounter {

	private int myNum = 0;

	public void incrementCounter() {
		myNum++;
	}

	public int getMyNum() {
		return myNum;
	}
}
