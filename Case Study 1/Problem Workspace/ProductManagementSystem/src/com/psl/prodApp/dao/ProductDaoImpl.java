package com.psl.prodApp.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.psl.prodApp.dto.Product;
import com.psl.prodApp.exception.ProdAppException;

public class ProductDaoImpl implements ProductDao{

	//you can implement more methods if needed
	
	@Override
	public Product addProduct(Product obj, String cateogoryName) throws ProdAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Product> getAllProducts() throws ProdAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> getProductById(int productId) throws ProdAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product deleteProduct(int productid) throws ProdAppException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
