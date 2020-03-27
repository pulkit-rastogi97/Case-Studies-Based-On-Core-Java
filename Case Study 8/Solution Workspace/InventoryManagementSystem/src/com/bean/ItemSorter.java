package com.bean;

import java.util.Comparator;

public class ItemSorter implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o2.getExpiryDate().compareTo(o1.getExpiryDate());
	}

}
