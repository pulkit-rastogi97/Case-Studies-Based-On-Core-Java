package com.psl.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.ParkingBlock;
import com.psl.exception.ParkingFullException;

public class ParkingSystemImpl implements ParkingSystem {

	@Override
	public Set<ParkingBlock> populateData(String fileName) 
	{
		Set<ParkingBlock> sBlocks = new TreeSet<ParkingBlock>(new Comparator<ParkingBlock>() 
			{
				@Override
				public int compare(ParkingBlock arg0, ParkingBlock arg1) {
					return arg0.getBlockNumber()-arg1.getBlockNumber();
			}
		});
		ParkingBlock parkingBlock;
		try 
		{
			if(fileName==null || fileName.isEmpty())
			{
				throw new FileNotFoundException();
			}
			else 
			{
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String string;
				while((string=bufferedReader.readLine())!=null)
				{
					if(string==null || string.isEmpty())
						continue;
					else 
					{
						String[] strings = new String[3];
						strings[0]="000";
						strings[1]="2000";
						strings[2]="0000";
						
						String[] tempArray = string.split(",");
						if(tempArray.length==1)
						{
							strings[0]=tempArray[0];
						}
						else if(tempArray.length==2)
						{
							strings[0]=tempArray[0];
							strings[1]=tempArray[1];
						}
						else if(tempArray.length==3)
						{
							strings[0]=tempArray[0];
							strings[1]=tempArray[1];
							strings[2]=tempArray[2];
						}
						parkingBlock = new ParkingBlock(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), 0000, 0.0);
						sBlocks.add(parkingBlock);												
					}
				}
				
				bufferedReader.close();
				if(sBlocks.isEmpty())
				{
					throw new IOException("File is empty");
				}
			}
		} 
		catch (IOException  e) 
		{
			System.out.println(e.getMessage());
		}	
		return sBlocks;
	}

	@Override
	public ParkingBlock removeVehicle(Set<ParkingBlock> treeSet, int vehicleNumber, int outitme) 
	{
		ParkingBlock parkingBlock = null;
		boolean flag = true;
		if(treeSet==null || treeSet.isEmpty())
		{
			parkingBlock = new ParkingBlock(0, vehicleNumber, 0, outitme, 0.0);
		}
		else 
		{				
			for(ParkingBlock parkingBlock2 : treeSet)
			{
				if(parkingBlock2.getVehicleNumber()==vehicleNumber)
				{
					parkingBlock2.setOutTime(outitme);
					parkingBlock2.setCharge(calculateCharge(parkingBlock2.getParkTime(),outitme));
					parkingBlock = parkingBlock2;
					parkingBlock2 = new ParkingBlock(parkingBlock.getBlockNumber(), 0, 0, 0, 0.0);
					flag = false;
					break;
				}
			}
		}
		if(flag)
		{
			parkingBlock = new ParkingBlock(0, vehicleNumber, 0, outitme, 0.0);
		}	
		return parkingBlock;
	}

	@Override
	public Set<ParkingBlock> sortByParkingTime(Set<ParkingBlock> treeSet) {
		
		Set<ParkingBlock> parkingBlocks = new TreeSet<ParkingBlock>(new Comparator<ParkingBlock>() 
			{
				@Override
				public int compare(ParkingBlock P1, ParkingBlock P2) {
					int time = P1.getParkTime()-P2.getParkTime();
					if(time==0)
						return P1.getBlockNumber()-P2.getBlockNumber();
					else {
						return time;
					}
			}
		});
		
		for (ParkingBlock parkingBlock : treeSet) {
			parkingBlocks.add(parkingBlock);
			
		}
		return parkingBlocks;
	}
	
	private double calculateCharge(int parkTime, int outTime)
	{
		parkTime+=1111;
		outTime+=1111;
		
		if(outTime<parkTime)
		{
			outTime+=2400;
		}
		
		int min = (outTime%100)-(parkTime%100);
		int hours = (outTime/100)-(parkTime/100);
		
		if(min<0)
		{
			min+=60;
			hours--;
		}
		
		double charge=(hours*10)+(min*(1/6));
		
		return charge;
		
	}

	@Override
	public void parkVehicle(Set<ParkingBlock> set, int vehicleNumber, int parkTime) throws ParkingFullException 
	{
		boolean flag = true;
		if(set==null || set.isEmpty())
			throw new ParkingFullException();
		else 
		{
			for(ParkingBlock parkingBlock : set)
			{
				if(parkingBlock.getVehicleNumber()==0)
				{
					parkingBlock.setVehicleNumber(vehicleNumber);
					parkingBlock.setParkTime(parkTime);
					flag = false;
					break;
				}
			}
		}
		
		if(flag)
		{
			throw new ParkingFullException();
		}		
	}
}
