package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.Cheese;
import com.bean.CheeseType;
import com.bean.Ingred;
import com.bean.Item;
import com.bean.ItemSorter;
import com.bean.Milk;
import com.bean.MilkType;
import com.bean.Wheat;
import com.bean.WheatType;
import com.exception.NoDataFoundException;

// Override and implement all the methods of DBConnectionUtil Interface in this class
public class InventoryServiceImpl implements InventoryService {

	DBConnectionUtil dbConnectionUtil;
	Connection connection;
	String sqlString;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Cheese cheese;
	Milk milk;
	Wheat wheat;
	Item item;
	
	public InventoryServiceImpl() 
	{
		dbConnectionUtil = new DatabaseConnectionManager();
		try {
		connection=dbConnectionUtil.getConnection();
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public List<Item> readAllItemsFromDb() {
		
		List<Item> list = new ArrayList<Item>();
		
		//Data from cheeseTable
		sqlString = "Select * from cheese_tbl";
		Map<Ingred,Float> calorieTable = new HashMap<Ingred,Float>();
		try 
		{
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlString);
			
			while(resultSet.next())
			{
				cheese = new Cheese();
				cheese.setId(resultSet.getInt(1));
				cheese.setDescription(resultSet.getString(2));
				cheese.setWeight(resultSet.getFloat(3));
				cheese.setPrice(resultSet.getFloat(4));
				cheese.setManufacturingDate(resultSet.getDate(5));
				cheese.setUseBeforeMonths(resultSet.getInt(6));
				cheese.setCheeseType(CheeseType.valueOf(resultSet.getString(7)));
				calorieTable.put(Ingred.valueOf("protein"),resultSet.getFloat(8));
				calorieTable.put(Ingred.valueOf("vitamin"),resultSet.getFloat(9));
				calorieTable.put(Ingred.valueOf("fat"),resultSet.getFloat(10));
				cheese.setCalorieTable(calorieTable);
				list.add(cheese);
				cheese=null;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		//Data from milkTable
		sqlString = "Select * from milk_tb";
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlString);
			while(resultSet.next())
			{
				milk = new Milk();
				milk.setId(resultSet.getInt(1));
				milk.setDescription(resultSet.getString(2));
				milk.setWeight(resultSet.getFloat(3));
				milk.setPrice(resultSet.getFloat(4));
				milk.setManufacturingDate(resultSet.getDate(5));
				milk.setUseBeforeMonths(resultSet.getInt(6));
				milk.setFatRate(resultSet.getFloat(7));
				milk.setMilkpacket(MilkType.valueOf(resultSet.getString(8)));
				list.add(milk);
				milk=null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		//Data from wheatTable
		sqlString = "Select * from wheat_tbl";
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlString);
			
			while (resultSet.next()) {
				wheat = new Wheat();
				wheat.setId(resultSet.getInt(1));
				wheat.setDescription(resultSet.getString(2));
				wheat.setWeight(resultSet.getFloat(3));
				wheat.setPrice(resultSet.getFloat(4));
				wheat.setManufacturingDate(resultSet.getDate(5));
				wheat.setUseBeforeMonths(resultSet.getInt(6));
				wheat.setWheatType(WheatType.valueOf(resultSet.getString(7)));
				list.add(wheat);	
				wheat=null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}

	@Override
	public void calculateExpiryDate(List<Item> items) {
		if(items==null || items.isEmpty())
			return;
		else {
			LocalDate localDate;
			Date date;
			for(Item item : items)	
			{
				localDate=item.getManufacturingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusMonths(item.getUseBeforeMonths());
				date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				item.setExpiryDate(date);		
			}
		}
		
	}

	@Override
	public void removeExpiredItems(List<Item> items) {
		if(items==null || items.isEmpty())
			return;
		else 
		{
			List<Item> iList = new ArrayList<Item>();
			for(Item item : items)
			{
				if(item.getExpiryDate().before(new Date()))
				{
					iList.add(item);
				}
			}
			items.removeAll(iList);
		}
		
	}

	@Override
	public void sortItems(List<Item> items) {
		Collections.sort(items,new ItemSorter());	
	}

	@Override
	public void applyDiscount(List<Item> items) 
	{
		
		LocalDate afterDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusMonths(6);
		LocalDate currDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate expiryDate;
		if(items==null || items.isEmpty())
			return;
		else 
		{
			List<Item> iList = new ArrayList<Item>();
			for(Item item : items)
			{
				expiryDate = item.getExpiryDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				if(expiryDate.isAfter(currDate) && expiryDate.isBefore(afterDate) || expiryDate.isEqual(afterDate) || expiryDate.isEqual(currDate))
				{
					iList.add(item);
				}
			}
			items.removeAll(iList);
			for(Item item : iList)
			{
				float discountedPrice = item.getPrice()-(item.getPrice()*0.20f);
				item.setPrice(discountedPrice);
			}
			items.addAll(iList);
	    }

	}

	@Override
	public List<Item> searchItem(String ItemType, List<Item> list) throws NoDataFoundException {
		
		if(list==null || list.isEmpty())
			throw new NoDataFoundException();
		else 
		{
			List<Item> items = new ArrayList<Item>();
			for(Item item : list)
			{
				if(item.getDescription().equalsIgnoreCase(ItemType))
					items.add(item);
					
			}
			if(items.isEmpty())
				throw new NoDataFoundException();
			else {
				return items;
			}
		}
	}
		
}
