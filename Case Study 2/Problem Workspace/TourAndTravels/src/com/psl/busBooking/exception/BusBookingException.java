package com.psl.busBooking.exception;

public class BusBookingException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1586277429365045161L;
	String msg;
	
	public BusBookingException(String msg)
	{
		super(msg);
		this.msg = msg;
	}
	
	@Override
	public String toString()
	{
		return this.msg;
	}

}
