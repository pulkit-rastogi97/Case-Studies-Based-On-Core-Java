package com.psl.prodApp.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.psl.prodApp.dto.Product;
import com.psl.prodApp.exception.ProdAppException;

public interface ProductService {
	Product addProduct(Product obj, String categoryName) throws ProdAppException;
	HashMap<Integer,Product> getAllProducts() throws ProdAppException;
	ArrayList<Product> getProductById(int productId) throws ProdAppException;
	Product deleteProduct(int productid) throws ProdAppException;
}
