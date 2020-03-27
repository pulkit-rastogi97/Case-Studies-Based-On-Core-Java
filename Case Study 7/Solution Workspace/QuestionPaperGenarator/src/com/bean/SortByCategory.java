package com.bean;

import java.util.Comparator;

public class SortByCategory implements Comparator<Question>{

	@Override
	public int compare(Question o1, Question o2) {
		return o1.getCategory().ordinal()-o2.getCategory().ordinal();
	}

}
