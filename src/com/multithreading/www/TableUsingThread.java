package com.multithreading.www;

class TableTwo extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("2 x " + i + " = " + (2 * i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TableFive extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("5 x " + i + " = " + (5 * i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TableUsingThread {

	public static void main(String[] args) {

		TableTwo t1 = new TableTwo();
		TableFive t2 = new TableFive();

		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		t2.start();
	}
}
