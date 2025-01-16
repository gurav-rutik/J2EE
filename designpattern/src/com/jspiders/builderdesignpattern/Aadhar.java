package com.jspiders.builderdesignpattern;

public class Aadhar {

	private long aadharNumber;
	private String dob;
	private String dist;
	
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	
	@Override
	public String toString() {
		return "Aadhar [aadharNumber=" + aadharNumber + ", dob=" + dob + ", dist=" + dist + "]";
	}
	
	
}
