package com.util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.bean.Show;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;

//Override and implement all the methods of DataManger Interface in this class
public class DataManagerImpl implements DataManager {

	public List<Show> populateDataFromFile(String fileName) {
		
		List<Show> shows = new ArrayList<Show>();
		try {
			if(fileName==null || fileName.isEmpty())
				throw new FileNotFoundException("File Not Found");
			FileInputStream fileInputStream = new FileInputStream(fileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Show show;
			while((show=(Show)objectInputStream.readObject())!=null)
			{
				shows.add(show);
			}
			objectInputStream.close();
		}catch(EOFException e)
		{
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}catch(ClassNotFoundException exception)
		{
			System.out.println(exception.getMessage());
		}
		return shows;
	}

	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats) throws SeatsNotAvailableException, UnknownShowException, InvalidSeatNumberException 
	{
	
		if(showList==null || showList.isEmpty())
			throw new UnknownShowException();
		
		boolean isShowAvailable = false;
		
		if(noOfSeats<=0)
			throw new InvalidSeatNumberException();
		
		for(Show show : showList)
		{
			if(show.getShowName().equalsIgnoreCase(showName))
			{
					isShowAvailable=true;
					if(show.getSeatsAvailable()>=noOfSeats)
					{
						show.setSeatsAvailable(show.getSeatsAvailable()-noOfSeats);
					}
					else
						throw new SeatsNotAvailableException();
					break;
			}
		}
		if(!isShowAvailable)
			throw new UnknownShowException();
			
	}
			
}
	

