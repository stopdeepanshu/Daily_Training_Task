package com.multithreadingmajortask.www;

public class CallRequest {
	private int requestId;
	private String phoneNumber;
	private int minutes;

	public CallRequest(int requestId, String phoneNumber, int minutes) {
		super();
		this.requestId = requestId;
		this.phoneNumber = phoneNumber;
		this.minutes = minutes;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

}
