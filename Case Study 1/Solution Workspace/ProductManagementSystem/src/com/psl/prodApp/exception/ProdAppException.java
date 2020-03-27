package com.psl.prodApp.exception;

public class ProdAppException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1586277429365045161L;
	String msg;
	
	public ProdAppException(String msg)
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
