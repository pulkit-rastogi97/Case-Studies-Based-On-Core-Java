package com.psl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psl.exception.NoDataFoundException;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

//Override all the methods of the PhoneBookContacts Interface
public class PhoneBookContactsImpl implements PhoneBookContacts {

	// use this Map to create the PhoneBook Contacts
	private Map<String, List<String>> contactMap = new HashMap<String, List<String>>();

	@Override
	public void addContact(String name, List<String> list) {
		contactMap.put(name, list);
		
	}

	@Override
	public Map<String, List<String>> getContactMap() {
		
		return contactMap;
	}

	@Override
	public List<String> searchContact(String name) throws NoDataFoundException {
		
		Map<String, List<String>>contactsMap = getContactMap();
		if(contactsMap.isEmpty())
			throw new NoDataFoundException();
		else
		{
			if(contactsMap.containsKey(name))
			{
				if(contactsMap.get(name)!=null || !contactsMap.get(name).isEmpty())
					return contactsMap.get(name);
				else 
					throw new NoDataFoundException();
				
			}
			else {
				throw new NoDataFoundException();
			}
		}
		
	}
	
	
	
	
	
}
