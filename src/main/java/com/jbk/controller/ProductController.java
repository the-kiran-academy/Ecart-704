package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.daoimpl.ProductDaoImpl;
import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.serviceimpl.ProductServiceImpl;

@RestController
public class ProductController {

	// ProductServiceImpl productServiceImpl=new ProductServiceImpl();

	// ProductService service=new ProductServiceImpl(); // I to C ( interface to
	// class )

	@Autowired
	private ProductService service;

	@PostMapping("/add-product") // incomming request
	public String addProduct(@RequestBody Product product) {

		// user want to add product data into list
		// in our case list = database
		
		int status = service.addProduct(product);
		if (status == 1) {
			return "Data Added;";
		} else {
			return "Data already Added;";
		}

	}

	@GetMapping("/get-product/{pid}")
	public Object getProductById(@PathVariable("pid") long id) {

		Product product = service.getProductById(id); // alt + shift + L it will complete left side

		if (product != null) {
			return product;
		} else {
			return "Product Not Found";
		}

	}

	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") long productId) {
		System.out.println(productId);
		return service.deleteProduct(productId);

	}

	@GetMapping("/get-all-product")
	public Object getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("get-product-by-name/{name}")
	public Object getProductByName(@PathVariable("name") String productName) {
		
		Product product = service.getProductByName(productName);
		
		if (product != null) {
			return product;
		} else {
			return "Product Not Found";
		}
		
	}
	
	@PutMapping("update-product")
	public String updateProduct(@RequestBody Product product) {
		
		return service.updateProduct(product);
		
	}

}
