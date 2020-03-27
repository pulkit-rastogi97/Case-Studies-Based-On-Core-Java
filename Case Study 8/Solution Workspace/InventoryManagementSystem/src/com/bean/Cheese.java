package com.bean;

import java.util.HashMap;
import java.util.Map;

public class Cheese extends Item {
	public CheeseType cheeseType ;
	public Map<Ingred,Float> calorieTable = new HashMap<Ingred,Float>();
	
	
	public Cheese() {
	}
	

	public CheeseType getCheeseType() {
		return cheeseType;
	}

	public void setCheeseType(CheeseType cheeseType) {
		this.cheeseType = cheeseType;
	}

	public Map<Ingred, Float> getCalorieTable() {
		return calorieTable;
	}

	public void setCalorieTable(Map<Ingred, Float> calorieTable) {
		this.calorieTable = calorieTable;
	}
		
}
