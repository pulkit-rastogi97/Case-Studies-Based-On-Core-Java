package com.psl.main;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.psl.bean.HeadOffice;
import com.psl.bean.Post;
import com.psl.util.SpeedPostImpl;


public class Client {
	
	public static void main(String[] args) {
		Map<HeadOffice, List<Post>> map = new SpeedPostImpl().populateData("HeadOffice.txt", "Post.txt");
		for(Map.Entry<HeadOffice, List<Post>> entry: map.entrySet())
		{
			System.out.println(entry);
		}
	}
}
