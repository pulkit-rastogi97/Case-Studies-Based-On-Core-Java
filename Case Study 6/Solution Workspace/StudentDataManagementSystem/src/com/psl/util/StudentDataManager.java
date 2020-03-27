package com.psl.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.psl.beans.Address;
import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;

//Override all the methods of the DataManager Interface
public class StudentDataManager implements DataManager {

	@Override
	public List<Student> populateData(String fileName) {
		List<Student> students = new ArrayList<Student>();

		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
		String string;
		String[] valueStrings;
		Student student;
		Address address;
		while((string=bufferedReader.readLine())!=null)
		{
			if(string.isEmpty())
				continue;
			else 
			{
				valueStrings = string.split(",");
				for(int i = 0; i<valueStrings.length; i++)
				{
					if(i==0 || i==2)
					{
						if(valueStrings[i]==null || valueStrings[i].isEmpty() || valueStrings[i].equals(" "))
							valueStrings[i]=Integer.toString(0);
					}
					else {
						if(valueStrings[i]==null || valueStrings[i].isEmpty() || valueStrings[i].equals(" "))
							valueStrings[i]=null;
					}
				}
				
			}
			student = new Student();
			address = new Address();
			student.setStudentName(valueStrings[1]);
			student.setRollno(Integer.parseInt(valueStrings[0]));
			student.setAge(Integer.parseInt(valueStrings[2]));
			address.setStreetName(valueStrings[3]);
			address.setCity(valueStrings[4]);
			address.setZipCode(valueStrings[5]);
			student.setAddress(address);
			students.add(student);
		}
		}catch(IOException exception)
		{
			System.out.println(exception.getMessage());
		}
		return students;
	}

	@Override
	public void validateData(List<Student> studentList) throws InsufficientDataException {
	
	List<Student> students = new ArrayList<Student>();
	boolean isInvalid=false;
	int count = 1;
	
	if(studentList.isEmpty())
		throw new InsufficientDataException();
	
	else 
	{
		for(Student student : studentList)
		{
			isInvalid=false;
			if(student==null)
				isInvalid=true;
			else 
			{
				if(student.getAge()==0)
					isInvalid=true;
				if(student.getRollno()==0)
					isInvalid=true;
				if(student.getStudentName()==null)
					isInvalid=true;
				if(student.getAddress()==null)
				{
					isInvalid=true;
				}
				else if(student.getAddress().getCity()==null || student.getAddress().getStreetName() == null || student.getAddress().getZipCode()==null)
				{
					isInvalid=true;
				}
			}
			if(isInvalid)
			{
				count++;
				students.add(student);
			}	
		}
	}
	if(count>1)
	{
		studentList.removeAll(students);// = removeAll(studentList,students);
		throw new InsufficientDataException();	
	}	
}
	@Override
	public void sortData(List<Student> studentList) {
		Collections.sort(studentList);
	}
}