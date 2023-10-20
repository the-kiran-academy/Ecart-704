package com.jbk.service;

import com.jbk.model.Product;

public interface ProductService {
	public int addProduct(Product product);
	public Product getProductById(long id);
	public String deleteProduct(long productId);
	public Object getAllProducts();
	public Product getProductByName(String productName);
	public String updateProduct(Product product);
}
