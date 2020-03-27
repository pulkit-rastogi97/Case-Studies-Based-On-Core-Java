package com.bean;

import java.util.Comparator;

public class SortByComplexity implements Comparator<Question>{

	@Override
	public int compare(Question o1, Question o2) {
		
		return o1.getComplexity().ordinal()-o2.getComplexity().ordinal();
		
	}

}
