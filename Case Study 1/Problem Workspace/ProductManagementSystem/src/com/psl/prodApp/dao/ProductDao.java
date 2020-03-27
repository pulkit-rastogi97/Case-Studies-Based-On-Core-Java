package com.psl.prodApp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import com.psl.prodApp.dto.Product;
import com.psl.prodApp.exception.ProdAppException;

public interface ProductDao {
	Product addProduct(Product obj, String cateogoryName) throws ProdAppException;
	HashMap<Integer,Product> getAllProducts() throws ProdAppException;
	ArrayList<Product> getProductById(int productId) throws ProdAppException;
	Product deleteProduct(int productid) throws ProdAppException;

}
