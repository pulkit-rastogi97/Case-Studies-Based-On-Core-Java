package com.psl;

public class Client {

	public String[] getTokens(String data) {	
		return data.split(" ");
	}

	public String reverseAndAppend(String[] data) {
		StringBuilder sBuilder;
		String s="";
		for(int i = 0; i< data.length; i++)
		{
			sBuilder = new StringBuilder(data[i]);
			s+=sBuilder.reverse()+" ";	
		}
		return s.trim();
	}

	public static void main(String[] args) {
		Client client=new Client();
		String[] tokens=client.getTokens("Hello World");
		client.reverseAndAppend(tokens);			
	}

}
