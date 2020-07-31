package com.psl.main;

import java.util.Set;

import com.psl.bean.ParkingBlock;
import com.psl.exception.ParkingFullException;
import com.psl.util.ParkingSystemImpl;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Set<ParkingBlock> sBlocks = new ParkingSystemImpl().populateData("walletParking.txt");
		for(ParkingBlock parkingBlock : sBlocks)
		{
			System.out.println(parkingBlock);
		}
	}
}
