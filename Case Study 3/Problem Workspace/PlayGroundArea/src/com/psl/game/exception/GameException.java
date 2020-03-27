package com.psl.game.exception;

public class GameException extends Exception{

	private static final long serialVersionUID = -694696063185180583L;
	String msg;
	public GameException(String msg)
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
