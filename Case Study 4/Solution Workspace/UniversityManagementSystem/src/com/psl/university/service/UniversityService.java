package com.psl.university.service;

import java.util.ArrayList;

import com.psl.university.dto.Student;
import com.psl.university.exception.UniversityException;

public interface UniversityService {

	public boolean createStudent(int stuId, String stuName, String deptName) throws UniversityException;
	public Student deleteStudent(int stuId) throws UniversityException;
	public ArrayList<Student> getStudentByDepartment(String departName) throws UniversityException;
}
