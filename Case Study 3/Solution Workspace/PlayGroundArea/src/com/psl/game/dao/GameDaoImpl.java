package com.psl.game.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;

import java.sql.PreparedStatement;
import com.psl.game.dto.Game;
import com.psl.game.exception.GameException;
import com.psl.game.util.DBUtil;

public class GameDaoImpl implements GameDao{
	
	HashMap<String,Integer> map = new HashMap<String,Integer>();
	public Connection con;
	public GameDaoImpl()
	{
		con=DBUtil.getConnection();
		map.put("Mario", 100);
		map.put("Badminton", 150);
		map.put("Cricket", 800);
		map.put("Chess", 200);
		map.put("Tennis",310);
		map.put("Football", 290);
		map.put("Kho-Kho", 180);
	}

	public int validateGame(String gameName) throws GameException {
		int gameCost=0;
		boolean flag=false;
		for(Entry<String,Integer> entry : map.entrySet())
		{
			if(entry.getKey().equalsIgnoreCase(gameName))
			{
				gameCost=entry.getValue();
				flag=true;
			}
		}
		if(!flag)
		{
			throw new GameException("Game is not available. Sorry for the inconvenience ");
		}
		return gameCost;
	}
	public Game validateUserId(int userId) throws GameException
	{
		Game game;
		String sql = "SELECT * FROM UserGameDetails WHERE userId = "+userId;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()==false)
			{
				throw new GameException("User Doesn't Exists");
			}
			rs.previous();
			rs.next();
			game=new Game(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}catch(SQLException e)
		{
			throw new GameException(e.getMessage());
		}
		return game;
	}
	@Override
	public Game playGame(int userId,String gameName) throws GameException
	{
		Game user = validateUserId(userId);
		int cost = validateGame(gameName);
		int balance = user.getBalance();
		
		if(balance>=cost)
		{
			
			String sql = "UPDATE UserGameDetails SET balance = ? WHERE userId = ?";
			
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, (user.getBalance()-cost));
				pstmt.setInt(2, user.getUserId());
				int row = pstmt.executeUpdate();
				System.out.println("row ="+row);
				if(row==1)
				{
					user.setBalance(balance-cost);
				}
				else
				{
					throw new GameException("Updation Failed : Database uncertainity issues ");
				}	
			} catch (SQLException e) {
				throw new GameException(e.getMessage());
			}	
			return user;
		}
		else
		{
			throw new GameException("Sorry "+user.getUserName()+" ! you, don't have sufficient balance to play this game. "+gameName+" is of price "+cost+" and your current balance is "+user.getBalance());	
			
		}
			
	}
	
	public HashMap<String,Integer> getAllGameDetails()
	{
		return map;
	}
	

}
