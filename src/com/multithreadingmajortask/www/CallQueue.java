package com.multithreadingmajortask.www;

public class CallQueue {

	private int requestId;
	private String phoneNumber;
	private int minutes;

	public CallQueue(int requestId, String phoneNumber, int minutes) {
		super();
		this.requestId = requestId;
		this.phoneNumber = phoneNumber;
		this.minutes = minutes;
	}

	public int getRequestId() {
		return requestId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getMinutes() {
		return minutes;
	}

}
