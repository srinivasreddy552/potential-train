package com.venkat.controller;

public class ErrorMessage {

	String msg;
	String details;

	public ErrorMessage(String msg, String details) {
		super();
		this.msg = msg;
		this.details = details;
	}

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
