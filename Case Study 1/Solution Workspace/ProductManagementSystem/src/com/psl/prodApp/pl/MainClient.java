package com.psl.prodApp.pl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.psl.prodApp.dto.Product;
import com.psl.prodApp.exception.ProdAppException;
import com.psl.prodApp.service.ProductService;
import com.psl.prodApp.service.ProductServiceImpl;

public class MainClient {

	public static void main(String[] args) {
		String prodName=null;
		int prodId = 0;
		Product prod = null;
		String CategoryName=null;
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		ProductService ps = new ProductServiceImpl();
		do{
		System.out.println("******************************************************");
		System.out.println("\t\tWELCOME TO PRODUCT INVENTORY SYSTEM");
		System.out.println("What would you like to do ? ");
		System.out.println("1. Add Product to inventory ");
		System.out.println("2. Display all products ");
		System.out.println("3. Display One Product By ProductId ");
		System.out.println("4. Delete One Product By ProductId ");
		System.out.println("5. Exit");
	    ch = sc.nextInt();
		try{
		switch(ch)
		{
		case 1 : //ps.getAllCategories();
				 System.out.println("Enter Product Name :: ");
				 prodName = sc.next();
				 System.out.println("Enter the Category Name :: ");
				 CategoryName = sc.next();
				 prod = new Product();
				 prod.setProductName(prodName);
				 System.out.println(" product name = "+prod.getProductName());
				 //prod.setCategoryId(categoryId);
				 prod = ps.addProduct(prod,CategoryName);				
				 System.out.println("Product inserted :: "+prod);
				 break;
		case 2:  HashMap<Integer,Product> map = ps.getAllProducts();
				 System.out.println("Products details are :: ");
				 for(Entry<Integer,Product> entry : map.entrySet())
				 {
					 System.out.println(entry);
				 }
				 break;
		case 3:  System.out.println("Enter Product Id :: ");
				 prodId = sc.nextInt();
				 ArrayList<Product> list = ps.getProductById(prodId);
				 for(Product p : list)
				 {
					 System.out.println(p);
				 }
				 break;
		case 4:  System.out.println("Enter Product Id :: ");
		 		 prodId = sc.nextInt();
		 		 Product p = ps.deleteProduct(prodId);
		 		 System.out.println("Deleted Product :: "+p);
		 		 break;
		case 5: break;
		 default:System.out.println("Invalid Choice");
		}
		}catch(ProdAppException e)
		{
			System.out.println(e.getMessage());
		}
		}while(ch>0 && ch<=4);
		sc.close();
	}
}
