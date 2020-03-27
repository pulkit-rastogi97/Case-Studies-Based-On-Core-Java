package com.bean;

import java.util.Date;

public class Item {
	private int id;
	private String description;
	private float weight;
	private float price;
	private Date manufacturingDate;
	private int useBeforeMonths;
	private Date expiryDate;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public int getUseBeforeMonths() {
		return useBeforeMonths;
	}
	public void setUseBeforeMonths(int useBeforeMonths) {
		this.useBeforeMonths = useBeforeMonths;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}	
}
