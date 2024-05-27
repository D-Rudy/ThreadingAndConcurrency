package com.rdz.concurrency.stampedLock;

import java.util.concurrent.locks.StampedLock;

public class ResourceOne {

	public int myVar = 100;

	StampedLock rOneLock = new StampedLock();

}
