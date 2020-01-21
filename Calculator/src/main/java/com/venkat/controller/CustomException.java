package com.venkat.controller;

import org.springframework.stereotype.Component;

@Component
public class CustomException extends RuntimeException {

	String msg;

	public CustomException(String msg) {
		super();
		this.msg = msg;
	}

	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
