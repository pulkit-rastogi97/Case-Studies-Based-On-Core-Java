package com.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;

public class DataManagerImpl implements DataManager {

	@Override
	public Map<String, List<String>> populateCityDataMap(String fileName) throws FileNotFoundException {
		FileReader fileReader = new FileReader(fileName);
		String[] arrStrings;
		Map<String, List<String>> stateCityMap = new HashMap<String, List<String>>();
		List<String> list;
		String string;
		try(BufferedReader bufferedReader = new BufferedReader(fileReader))
		{
			while((string=bufferedReader.readLine())!=null)
			{
				if(string.isEmpty())
				{
					continue;
				}
				list = new LinkedList<String>();
				arrStrings=string.split("-");
				if(stateCityMap.containsKey(arrStrings[0]))
				{
					list=stateCityMap.get(arrStrings[0]);
					list.add(arrStrings[1]);
					stateCityMap.replace(arrStrings[0], list);
				}
				else 
				{
					list.add(arrStrings[1]);
					stateCityMap.put(arrStrings[0], list);
				}		
				}
		}
		catch(IOException e)
		{
				System.out.println(e.getMessage());
		}
		return stateCityMap;
	}

	@Override
	public List<String> getCities(Map<String, List<String>> stateCityMap,
			String state) throws InvalidStateException {
		
		if(stateCityMap.isEmpty() || state==null || state.isEmpty() || !stateCityMap.containsKey(state))
		{
			throw new InvalidStateException();
		}
		else 
			return stateCityMap.get(state);
	}

	@Override
	public String getState(Map<String, List<String>> stateCityMap, String city) throws CityNotFoundException {
		boolean isCityPresent = false;
		String state = null;
		if(stateCityMap.isEmpty() || city==null || city.isEmpty())
		{
			throw new CityNotFoundException();
		}
		else 
		{
			for(Map.Entry<String, List<String>> entryMap : stateCityMap.entrySet())
			{
				if(entryMap.getValue().contains(city))
				{
					isCityPresent = true;
					state = entryMap.getKey();
					break;
				}
			}
		}
		if(isCityPresent)
		{
			return state;
		}
		else 
			throw new CityNotFoundException();
	}
}
