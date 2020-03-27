package com.psl.prodApp.dto;

public class Product
{
	int productid, categoryId;
	String productName;
	public Product(int productid, int categoryId, String productName) {
		this.productid = productid;
		this.categoryId = categoryId;
		this.productName = productName;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", categoryId=" + categoryId
				+ ", productName=" + productName + "]";
	}
	
	
}
