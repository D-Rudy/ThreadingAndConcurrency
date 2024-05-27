package com.rdz.concurrency.ExplicitLocking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceOne {

	public int myVar = 100;

	Lock rOneLock = new ReentrantLock();

}
