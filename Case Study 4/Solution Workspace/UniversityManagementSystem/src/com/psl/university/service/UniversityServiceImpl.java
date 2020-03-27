package com.psl.university.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.psl.university.dto.Department;
import com.psl.university.dto.Student;
import com.psl.university.exception.UniversityException;

public class UniversityServiceImpl implements UniversityService{

	HashMap<Integer,Student> mapStu = new HashMap<>();
	HashMap<Integer,Department> mapDept = new HashMap<>();
	Department dept;
	Student stu;
	public UniversityServiceImpl()
	{
		
		mapDept.put(101, new Department(101,"Electronics",40));
		mapDept.put(102, new Department(102,"ComputerScience",60));
		mapDept.put(103, new Department(103,"Mechanical",50));
		mapDept.put(104, new Department(104,"Petroleum",30));
		mapDept.put(105, new Department(105,"Aerospace",20));
		mapDept.put(106, new Department(106,"Chemical",40));
		mapDept.put(107, new Department(107,"Civil",60));
		
	}
	@Override
	public boolean createStudent(int stuId, String stuName, String deptName) throws UniversityException {
		boolean isDeptValid = validateDeptName(deptName);
		if(isDeptValid)
		{
			stu = new Student(stuId,stuName,deptName);
			mapStu.put(stu.getStuId(),stu);
		}
		else
		{
			throw new UniversityException("Insertion Failed : Due to unknown reasons");
		}
		return isDeptValid;
	}
	
	public boolean validateDeptName(String deptName) throws UniversityException
	{
		boolean flag = false;
		for(Entry<Integer,Department> entry : mapDept.entrySet())
		{
			//System.out.println(entry);
			if(entry.getValue().getDeptName().equalsIgnoreCase(deptName))
			{
				flag = true;
				break;
			}
		}
		if(!flag)
			throw new UniversityException("Department doesn't exists ");
		else
			return flag;
	}

	@Override
	public Student deleteStudent(int stuId) throws UniversityException {
		boolean flag = false;
		//try {
			if(mapStu.isEmpty())
			{
				throw new UniversityException("No Student exists");
			}
		for(Entry<Integer,Student> entry : mapStu.entrySet())
		{
			if(entry.getKey()==stuId)
			{
				flag = true;
				stu = entry.getValue();
				mapStu.remove(entry.getKey());
			}
		}
		if(!flag)
		{
			throw new UniversityException("No student with "+stuId+" found");
		}
		else
			return stu;
		
	}

	@Override
	public ArrayList<Student> getStudentByDepartment(String deptName) throws UniversityException {
		boolean isDeptValid = validateDeptName(deptName);
		ArrayList<Student> listStu;
		boolean flag = false;
		if(isDeptValid)
		{
			listStu = new ArrayList<Student>();
			for(Entry<Integer,Student> entry : mapStu.entrySet())
			{
				if(entry.getValue().getDeptName().equalsIgnoreCase(deptName))
				{
					listStu.add(entry.getValue());
					flag = true;
				}
			}
			if(!flag)
				throw new UniversityException("No Student is enrolled in "+deptName+" department");
		}
		else
		{
			throw new UniversityException("Insertion Failed : Due to unknown reasons");
		}
		return listStu;
		
	}
	
	

}
