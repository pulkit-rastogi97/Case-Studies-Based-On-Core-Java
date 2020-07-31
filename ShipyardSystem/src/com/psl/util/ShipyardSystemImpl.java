package com.psl.util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.psl.bean.Destination;
import com.psl.bean.Ship;

public class ShipyardSystemImpl implements ShipyardSystem {

	@Override
	public List<Ship> populateData(String fileName) 
	{	
		List<Ship> ships = new ArrayList<Ship>();
		try 
		{
			if(fileName==null || fileName.isEmpty())
			{
				throw new FileNotFoundException("Filename can't be null or empty");
			}
			else 
			{
				FileInputStream fileInputStream = new FileInputStream(fileName);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				Ship ship;
				while((ship = (Ship)objectInputStream.readObject()) != null)
				{		
					ships.add(ship);
				}
				objectInputStream.close();
			}
			if(ships.isEmpty())
			{
				throw new IOException("File is Empty");
			}
		} catch (EOFException e) {
			
		} catch (IOException e) {
			System.out.println(e);
		}
		catch (ClassNotFoundException  e) {
			System.out.println(e.getMessage());
		}
		return ships;
	}

	@Override
	public void calculateEndDate(String locationFile, List<Ship> list) {
		List<Destination> destinations = new ArrayList<Destination>();
		try 
		{
			if(locationFile==null || locationFile.isEmpty() || list==null || list.isEmpty())
			{
				throw new FileNotFoundException("Filename can't be null or empty");
			}
			else 
			{
				FileInputStream fileInputStream = new FileInputStream(locationFile);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				Destination destination;
				while((destination = (Destination)objectInputStream.readObject()) != null)
				{	
					destinations.add(destination);
				}
				objectInputStream.close();
			}
			if(destinations.isEmpty())
			{
				throw new IOException("File is Empty");
			}
		} catch (EOFException e) {
			
		} catch (IOException e) {
			System.out.println(e);
		}
		catch (ClassNotFoundException  e) {
			System.out.println(e.getMessage());
		}
		for(int i = 0; i<list.size(); i++)
		{
			for(int j = 0; j<destinations.size(); j++)
			{
				if(list.get(i).getDestinationName().equalsIgnoreCase(destinations.get(j).getDestinationName()))
				{
					list.get(i).setNumberOfDays(destinations.get(j).getNumberOfDays());
					LocalDate enDate = new java.sql.Date(list.get(i).getStartDate().getTime()).toLocalDate();
					LocalDate answerDate = enDate.plusDays(destinations.get(j).getNumberOfDays());
					list.get(i).setEndDate(java.sql.Date.valueOf(answerDate));
					break;
				}
			}
		}
	}

	@Override
	public void sortByLongestJourney(List<Ship> list) 
	{	
		Collections.sort(list,new SortByDate());
	}

	@Override
	public void calculateCost(List<Ship> list) 
	{
		for (int i = 0; i < list.size(); i++) 
		{
			int days = list.get(i).getNumberOfDays();
			if(days>100)
				list.get(i).setTotalCost((days*100)-((days-100)*30));
			else
				list.get(i).setTotalCost(days*100);
		}
		
	}
}
class SortByDate implements Comparator<Ship>{

	@Override
	public int compare(Ship o1, Ship o2) 
	{
		return o2.getNumberOfDays()-o1.getNumberOfDays();
	}
	
}
