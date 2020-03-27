package com.psl.busBooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;

import com.psl.busBooking.dto.Bus;
import com.psl.busBooking.exception.BusBookingException;
import com.psl.busBooking.util.DBUtil;

public class BusBookingDaoImpl implements BusBookingDao{

	Connection con;
	public BusBookingDaoImpl()
	{
		con = DBUtil.getConnection();
	}
	@Override
	public HashMap<Integer, Bus> showAllBusDetails() throws BusBookingException {
		HashMap<Integer,Bus> map = new HashMap<Integer,Bus>();
		String sql = "SELECT * FROM BusDetails";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()==false)
			{
				throw new BusBookingException("No Buses Available ");
			}
			else
			{
				rs.previous();
				while(rs.next())
				{
					int busId = rs.getInt(1);
					map.put(busId, new Bus(busId,rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
					
				}
			}
			
		} catch (SQLException e) {
			throw new BusBookingException(e.getMessage());
		}
		
		return map;
	}

	@Override
	public HashMap<Integer, Bus> getBusDetails(String from, String to) throws BusBookingException {
		HashMap<Integer,Bus> getMap = showAllBusDetails();
		HashMap<Integer,Bus> returnMap = new HashMap<Integer,Bus>();
		for(Entry<Integer, Bus> entry : getMap.entrySet())
		{
			Bus bus = entry.getValue();
			if(bus.getFrom().equalsIgnoreCase(from) && bus.getTo().equalsIgnoreCase(to))
			{
				returnMap.put(entry.getKey(),entry.getValue());
			}
		}
		if(returnMap.isEmpty())
		{
			throw new BusBookingException("No buses available");
		}
		//System.out.println("Return Map Values :: "+returnMap);
		return returnMap;
	}
	public void subtractBus(int id,int seats) throws BusBookingException
	{
		String sql = "UPDATE BusDetails SET noOfSeats = "+seats+" WHERE busId = "+id;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			int row = pstmt.executeUpdate();
			if(row!=1)
			{
				throw new BusBookingException("Seats not Available");
			}
		} catch (SQLException e) {
			throw new BusBookingException(e.getMessage());
		}
		
	}
	@Override
	public Bus bookBus(int busId) throws BusBookingException {
		String sql = "SELECT * FROM BusDetails WHERE busId = "+busId;
		Bus bus = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()==false)
			{
				throw new BusBookingException("No Bus with bus Id = "+busId+" found");
			}
			else
			{
				int seats=rs.getInt(6);
				if(seats==0)
				{
					throw new BusBookingException("Seats Not Available");
				}
				subtractBus(busId,seats-1);
				bus = new Bus(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),seats-1);			
			}
		} catch (SQLException | BusBookingException e) {
			throw new BusBookingException(e.getMessage());
		}				
		return bus;
	}

}
