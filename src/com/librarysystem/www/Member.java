package com.librarysystem.www;

public class Member {

	private String memberName;
	private int memberId;
	private String memberAddress;

	public Member(String memberName, int memberId, String memberAddress) {
		super();
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberAddress = memberAddress;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

}
