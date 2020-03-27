package com.psl;

public class Client {

	public String convertToTitle(String string){
	
		 if (string == null || string.isEmpty()) {
		        return string;
		    }
		 
		    StringBuilder newString = new StringBuilder();
		 
		    boolean convertNext = true;
		    for (char ch : string.toCharArray()) {
		        if (Character.isSpaceChar(ch)) {
		            convertNext = true;
		        } else if (convertNext) {
		            ch = Character.toTitleCase(ch);
		            convertNext = false;
		        } else {
		            ch = Character.toLowerCase(ch);
		        }
		        newString.append(ch);
		    }
		 
		    return newString.toString();
        
	}
		public static void main(String[] args) {
				Client client = new Client();
				client.convertToTitle(null);
	
		}
}
