package com.psl.university.service;

import java.util.ArrayList;

import com.psl.university.dto.Student;
import com.psl.university.exception.UniversityException;

public class UniversityServiceImpl implements UniversityService{

	@Override
	public boolean createStudent(int stuId, String stuName, String deptName) throws UniversityException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student deleteStudent(int stuId) throws UniversityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> getStudentByDepartment(String departName) throws UniversityException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
