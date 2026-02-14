package com.multithreading.www;

public class threadPractise {
	public static void main(String[] args) {

		
		Runnable r1 = () -> {
			for (int i = 1; i <= 5; i++) {

				System.out.println("Hi this is " + Thread.currentThread().getName() + " " + i);

			}
		};

		Thread t1 = new Thread(r1);
		t1.setName("newThread1");

		Thread t2 = new Thread(r1, "Thread-2");

		t1.start();
		t2.start();
	}
}
