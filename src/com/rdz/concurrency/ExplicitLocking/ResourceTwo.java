package com.rdz.concurrency.ExplicitLocking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceTwo {

	public int myVar = 1000;
	Lock rTwoLock = new ReentrantLock();

}
