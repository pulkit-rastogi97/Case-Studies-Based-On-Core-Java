package com.psl.util;

import java.util.List;
import java.util.Map;

import com.psl.exception.NoDataFoundException;

public interface PhoneBookContacts {

	void addContact(String name,List<String> list);
	Map<String, List<String>> getContactMap();
	List<String> searchContact(String name) throws NoDataFoundException;
	
}
