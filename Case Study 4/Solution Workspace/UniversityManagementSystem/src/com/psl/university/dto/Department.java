package com.psl.university.dto;

public class Department {
	private int deptId;
	private String deptName;
	private int strength;
	public Department(int deptId, String deptName, int strength) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.strength = strength;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", strength=" + strength + "]";
	}
	

}
