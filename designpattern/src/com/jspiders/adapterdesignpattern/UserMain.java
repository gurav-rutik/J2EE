package com.jspiders.adapterdesignpattern;

public class UserMain {

	public static void main(String[] args) {

		UserService userService = new UserService();
		userService.signUp();
		userService.logIn();

	}

}