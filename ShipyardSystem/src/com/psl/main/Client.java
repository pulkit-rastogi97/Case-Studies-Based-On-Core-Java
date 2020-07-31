package com.psl.main;

import java.util.List;

import com.psl.bean.Ship;
import com.psl.util.ShipyardSystemImpl;

public class Client {

	public static void main(String[] args) {
		
		List<Ship> ships = new ShipyardSystemImpl().populateData("ship.ser");
		for(Ship ship : ships)
		{
			System.out.println(ship);
		}
		new ShipyardSystemImpl().calculateEndDate("destination.ser", ships);
		System.out.println();
		System.out.println();
		for(Ship ship : ships)
		{
			System.out.println(ship);
		}
		System.out.println();
		System.out.println();
		new ShipyardSystemImpl().sortByLongestJourney(ships);
		for(Ship ship : ships)
		{
			System.out.println(ship);
		}
		System.out.println();
		System.out.println();
		new ShipyardSystemImpl().calculateCost(ships);
		for(Ship ship : ships)
		{
			System.out.println(ship);
		}
		
	}

}
