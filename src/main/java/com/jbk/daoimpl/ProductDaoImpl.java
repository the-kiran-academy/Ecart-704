package com.jbk.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	List<Product> list = new ArrayList<>();

	ProductDaoImpl() {
		list.add(new Product(101, "pen", 1, 1, 100, 10));
		list.add(new Product(102, "java book", 1, 1, 450, 10));
		list.add(new Product(103, "python book", 1, 1, 500, 10));

		System.out.println("in product dao impl");
	}

	@Override
	public int addProduct(Product product) {

		Product prdById = getProductById(product.getProductId());
		Product prdByName = getProductByName(product.getProductName());
		if (prdById==null && prdByName==null) {
			list.add(product);
			return 1;
		}else {
			return 2;
		}	
	}

	@Override
	public Product getProductById(long id) {

		for (Product product : list) {
			if (product.getProductId() == id) {
				return product;
			}
		}

		return null;
	}

	@Override
	public String deleteProduct(long productId) {
		String msg = null;

		if (!list.isEmpty()) {
			for (Product product : list) {
				if (product.getProductId() == productId) {
					list.remove(product);
					msg = "Product Removed";
					break;
				} else {
					msg = "Product Not Found To Delete";
				}

			}
		} else {
			msg = "Empty List";
		}

		return msg;

	}

	@Override
	public List<Product> getAllProducts() {

		return list;
	}

	@Override
	public Product getProductByName(String productName) {
		for (Product product : list) {
			if (product.getProductName().equals(productName)) {
				return product;
			}
		}

		return null;
	}

	@Override
	public String updateProduct(Product product) {
		for (Product listProduct : list) {
			
			if(listProduct.getProductId()==product.getProductId()) {
				list.set(list.indexOf(listProduct), product);	
				break;
			}
			
		}
		return "Updated";
	}

}
