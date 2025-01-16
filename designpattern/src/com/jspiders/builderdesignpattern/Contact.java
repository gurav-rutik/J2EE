package com.jspiders.builderdesignpattern;


public class Contact {

	private String firstName;
	private String lastName;
	private String email;
	private long mobile;
	private long home;
	private long work;
	private int landline;
	private String gender;
	private Address address;
	private Website website;
	private Aadhar aadhar;
	
	public Contact(String firstName, String lastName, String email, long mobile, long home, long work, int landline, String gender, Address address, Website website, Aadhar aadhar) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.home = home;
		this.work = work;
		this.landline = landline;
		this.gender = gender;
		this.address = address;
		this.website = website;
		this.aadhar = aadhar;
	}
	
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobile=" + mobile
				+ ", home=" + home + ", work=" + work + ", landline=" + landline + ", gender=" + gender
				+ ", address=" + address + ", website=" + website + ", aadhar=" + aadhar + "]";
	}

	

}