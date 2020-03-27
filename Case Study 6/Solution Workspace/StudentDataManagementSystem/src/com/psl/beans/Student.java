package com.psl.beans;

public class Student implements Comparable<Student>{
	private int rollno;
	private String studentName;
	private int age;
	private Address address;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollno, String studentName, int age, Address address) {
		super();
		this.rollno = rollno;
		this.studentName = studentName;
		this.age = age;
		this.address = address;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", studentName=" + studentName
				+ ", age=" + age + ", address=" + address + "]";
	}

	@Override
	public int compareTo(Student o2) {
		int returnValue;
		if(getStudentName().compareTo(o2.getStudentName())==0)
		{
			if(getAge()-o2.getAge()==0)
			{
				returnValue=getRollno()-o2.getRollno();
			}
			else 
			{
				returnValue = getAge()-o2.getAge();
			}
		}
		else 
		{
			returnValue = getStudentName().compareTo(o2.getStudentName());
		}
		return returnValue;
	}
}
