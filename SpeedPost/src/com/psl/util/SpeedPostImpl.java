package com.psl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.psl.bean.HeadOffice;
import com.psl.bean.Post;

public class SpeedPostImpl implements SpeedPost {

	@Override
	public Map<HeadOffice, List<Post>> populateData(String HeadOfficeFileName, String postFileName) 
	{
		Post post;
		HeadOffice headOffice;
		List<Post> posts= new ArrayList<Post>();
		Map<HeadOffice, List<Post>> map = new HashMap<HeadOffice, List<Post>>();
		FileReader fileReader;
		BufferedReader bufferedReader;
		String string;
		try 
		{
			if(HeadOfficeFileName==null || HeadOfficeFileName.isEmpty() || postFileName==null || postFileName.isEmpty())
			{
				throw new FileNotFoundException("File not found");
			}
			else 
			{
				fileReader = new FileReader(postFileName);
				bufferedReader = new BufferedReader(fileReader);
				while((string=bufferedReader.readLine())!=null)
				{
					String[] value = string.split(",");
					Date date = new SimpleDateFormat("yyyy/MM/dd").parse(value[1]);
					post=new Post(value[0], date, value[2], value[3]);
					posts.add(post);	
				}
				bufferedReader.close();
				fileReader = new FileReader(HeadOfficeFileName);
				bufferedReader = new BufferedReader(fileReader);
				while((string=bufferedReader.readLine())!=null)
				{
					List<Post> temPosts = new ArrayList<Post>();
					String[] value = string.split(",");
					String[] pincodes = value[2].split("-");
					pincodes[0]=pincodes[0].substring(1);
					pincodes[pincodes.length-1]=pincodes[pincodes.length-1].substring(0,pincodes[pincodes.length-1].length()-1);
					for(String pin : pincodes)
					{
						for(Post post2: posts)
						{
							if(pin.equals(post2.getPinCode()))
							{
								temPosts.add(post2);
							}
						}
					}
					List<String> pinOfCodes = Arrays.asList(pincodes);
					headOffice= new HeadOffice(value[0], value[1], pinOfCodes);
					map.put(headOffice, temPosts);
				}
			}
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			
			System.out.println(e.getMessage());
		}
		return map;
	}

	@Override
	public List<Post> mostOldestPost(Map<HeadOffice, List<Post>> map) 
	{
		List<Post> posts = new ArrayList<Post>();
		for(Map.Entry<HeadOffice, List<Post>> entry: map.entrySet())
		{
			posts.addAll(entry.getValue());
		}
		
		Set<E>
		Map<Date, Post> posMap = new TreeMap<Date, Post>();
		for(Post post: posts)
		{
			posMap.put(post.getPostDate(), post);
		}
		
		return null;
	}

	@Override
	public HeadOffice trackPost(Map<HeadOffice, List<Post>> map, String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> sortByAge(Map<HeadOffice, List<Post>> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
