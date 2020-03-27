package com.psl.prodApp.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.psl.prodApp.dao.ProductDao;
import com.psl.prodApp.dao.ProductDaoImpl;
import com.psl.prodApp.dto.Product;
import com.psl.prodApp.exception.ProdAppException;

public class ProductServiceImpl implements ProductService{

	ProductDao ref = new ProductDaoImpl();
	@Override
	public Product addProduct(Product obj, String CategoryName) throws ProdAppException {
		return ref.addProduct(obj,CategoryName);
	}

	@Override
	public HashMap<Integer, Product> getAllProducts() throws ProdAppException {
		return ref.getAllProducts();
	}

	@Override
	public ArrayList<Product> getProductById(int productId) throws ProdAppException {
		// TODO Auto-generated method stub
		return ref.getProductById(productId);
	}

	@Override
	public Product deleteProduct(int productid) throws ProdAppException {
		
		return ref.deleteProduct(productid);
	}

}
