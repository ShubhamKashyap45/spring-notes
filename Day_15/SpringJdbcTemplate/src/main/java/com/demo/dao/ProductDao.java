package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void saveProduct(Product p);

	List<Product> findAll();

	Product findById(int pid);

	List<Product> findByPrice(double price);

	boolean deleteById(int pid);

	boolean modifyById(int pid, int qty, double price);

}
