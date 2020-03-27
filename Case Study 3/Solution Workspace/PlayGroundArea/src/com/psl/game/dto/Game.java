package com.psl.game.dto;

public class Game {

	private int userId;
	private String userName;
	private int balance;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Game() {
	}
	public Game(int userId, String userName, int balance) {
		this.userId = userId;
		this.userName = userName;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Game [userId=" + userId + ", userName=" + userName
				+ ", balance=" + balance + "]";
	}
	
	
}
