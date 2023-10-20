package com.jbk.dao;

import java.util.List;

import com.jbk.model.Product;

public interface ProductDao {
	
	public int addProduct(Product product);
	public Product getProductById(long productId);
	
	public String deleteProduct(long productId);
	public List<Product> getAllProducts();
	public Product getProductByName(String productName);
	public String updateProduct(Product product);

}
