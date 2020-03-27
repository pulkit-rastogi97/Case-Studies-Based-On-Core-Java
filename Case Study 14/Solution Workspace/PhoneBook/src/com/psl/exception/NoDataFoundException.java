package com.psl.exception;

public class NoDataFoundException extends Exception {

	public NoDataFoundException(){
		super("No Data Found");
	}
	
	public NoDataFoundException(String msg){
		super(msg);
	}
}
