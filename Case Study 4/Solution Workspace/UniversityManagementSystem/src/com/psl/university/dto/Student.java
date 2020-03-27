package com.psl.university.dto;

public class Student {

	private int stuId;
	private String stuName;
	private String deptName;
	public Student(int stuId, String stuName, String deptName) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.deptName = deptName;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", deptName=" + deptName + "]";
	}
	
	
}
