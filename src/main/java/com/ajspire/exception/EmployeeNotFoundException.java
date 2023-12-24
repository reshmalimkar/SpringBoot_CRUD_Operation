package com.ajspire.exception;

public class EmployeeNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public EmployeeNotFoundException(String str) {
		super(str);
		this.msg=str;
	}
	public String getMsg() {
		return msg;
	}
	
	

}
