package com.rdz.concurrency.stampedLock;

import java.util.concurrent.locks.StampedLock;

public class ResourceTwo {

	public int myVar = 1000;
	StampedLock rTwoLock = new StampedLock();

}
