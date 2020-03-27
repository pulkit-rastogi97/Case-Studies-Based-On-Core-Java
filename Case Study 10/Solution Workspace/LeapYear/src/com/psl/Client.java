package com.psl;

public class Client {

	public boolean isLeapYear(int year) {
		if(year<=0)
			return false;
		if((year%4==0) || ((year%100==0) && (year%400==0)))
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.isLeapYear(2020);
	}

}
