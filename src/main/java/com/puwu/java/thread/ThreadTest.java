package com.puwu.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadTest implements Runnable {
	
	public static Logger log = LogManager.getLogger(ThreadTest.class.getName());
	
	public int count = 0;
	
	private String threadName;
	
	public ThreadTest (int count, String threadName) {
		this.count = count;
		this.threadName = threadName;
	}
	
	public void run() {
		synchronized (log) {
			for (int i = 0; i < 10; i++){
				count++;
				System.out.println(threadName + " 计数器=" + count);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 10; i++) {
			ThreadTest test = new ThreadTest(0, "线程" + i);
			pool.execute(test);
		}
	}

}
