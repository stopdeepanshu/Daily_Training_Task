package com.multithreadingmajortask.www;

public class Driver {

	public static void main(String[] args) {

		SharedResource sr=new SharedResource();
		
		Thread producerThread = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				sr.producer(i);
			}
		});

		Thread consumerThread = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				sr.consumer();
			}
		});

		producerThread.start();
		consumerThread.start();
	}
}
