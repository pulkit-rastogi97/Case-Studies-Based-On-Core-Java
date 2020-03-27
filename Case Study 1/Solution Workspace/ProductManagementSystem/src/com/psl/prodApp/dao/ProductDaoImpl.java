package com.psl.prodApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.psl.prodApp.dto.Category;
import com.psl.prodApp.dto.Product;
import com.psl.prodApp.exception.ProdAppException;
import com.psl.prodApp.util.DBUtil;

public class ProductDaoImpl implements ProductDao{

	Connection con;
	public ProductDaoImpl()
	{
		con=DBUtil.getConnection();
	}
	
	@Override
	public Product addProduct(Product obj,String CategoryName) throws ProdAppException{
		ResultSet rs= null;
		int categoryId = getCategoryId(CategoryName, getAllCategories());
		System.out.println(categoryId);
		String sql = "INSERT INTO products(productName,categoryId) VALUES (?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, obj.getProductName());
			pstmt.setInt(2, categoryId);
			obj.setCategoryId(categoryId);
			int row = pstmt.executeUpdate();
			if(row>0)
			{
				rs = pstmt.getGeneratedKeys();
				if(rs.next())
					obj.setProductid(rs.getInt(1));
			}
			else
			{
				throw new ProdAppException("Insertion Failed");
			}
		} catch (SQLException e) {
			throw new ProdAppException(e.getMessage());
		}
		return obj;
	}

	@Override
	public HashMap<Integer, Product> getAllProducts() throws ProdAppException {
		String sql = "SELECT * FROM products ORDER BY FIELD(categoryId,1,2,3,4) ASC ";
		LinkedHashMap<Integer, Product> map = new LinkedHashMap<Integer,Product>();
		Product prod = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()==true)
			{
				rs.previous();
				while(rs.next())
				{
					int prodId=rs.getInt(1);
					prod = new Product(prodId,rs.getInt(3),rs.getString(2));
					map.put(prodId, prod);
				}
			}
			else
			{
				throw new ProdAppException("No Products in the databse ");
			}			
		} catch (SQLException e) {
			throw new ProdAppException(e.getMessage());
		}
		return map;
	}

	@Override
	public ArrayList<Product> getProductById(int productId) throws ProdAppException {
		ArrayList<Product> list = new ArrayList<Product>();
		Product product = null;
		String sql ="SELECT * FROM products WHERE productId = "+productId;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				product = new Product(rs.getInt(1),rs.getInt(3),rs.getString(2));
				list.add(product);
			}else
			{
				throw new ProdAppException("No Product with productId "+productId+" found");
			}
		} catch (SQLException e) {
			throw new ProdAppException(e.getMessage());
		}
		return list;
	}

	@Override
	public Product deleteProduct(int productid) throws ProdAppException {
		ArrayList<Product> list = getProductById(productid);
		String sql = "DELETE FROM products WHERE productId = "+productid;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			int row = pstmt.executeUpdate();
			if(row==1)
			{
				return list.get(0);
			}
			else
			{
				throw new ProdAppException("Deletion Failed");
			}
		} catch (SQLException e) {
			throw new ProdAppException(e.getMessage());
		}
		
	}
	
	public ArrayList<Category> getAllCategories() throws ProdAppException
	{
		ArrayList<Category> categories = new ArrayList<Category>();
		Category category = null;
		String sql = "SELECT * FROM categories ";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//System.out.format("%-15s -> %-15s","CategoryId","CategoryName");
			while(rs.next())
			{
				category=new Category(rs.getInt(1),rs.getString(2));
				categories.add(category);
			}
		} catch (SQLException e) {
						throw new ProdAppException(e.getMessage());
		}
		return categories;	
	}
	
	public int getCategoryId(String name, ArrayList<Category> categories) throws ProdAppException
	{
		boolean doesExists = false;
		int id = 0;
		for(Category c : categories)
		{
			if(c.getCategoryName().equalsIgnoreCase(name))
			{
				doesExists=true;
				id=c.getCategoryId();
				break;
			}
		}
		if(doesExists)
		{
			return id;
		}
		else
		{
			throw new ProdAppException("Insertion Failed : Category doesn't exists ");
		}
	}
}
