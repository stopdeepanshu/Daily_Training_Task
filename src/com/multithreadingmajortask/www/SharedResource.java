package com.multithreadingmajortask.www;

public class SharedResource {

	volatile int data;
	volatile boolean available = false;

	public synchronized void producer(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		data = value;
		System.out.println("Produced: " + data);

		available = true;
		notify();

	}

	public synchronized void consumer() {

		while (available == false) {

			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("Consumer: "+data);
		available = false;
		notify();

	}
}
