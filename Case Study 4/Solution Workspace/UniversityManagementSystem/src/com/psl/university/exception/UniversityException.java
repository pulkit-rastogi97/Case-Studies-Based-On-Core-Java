package com.psl.university.exception;

public class UniversityException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4978758291454550033L;
	
	String msg;
	public UniversityException(String msg) {
		super(msg);
		//this.msg=msg;
	}

}
