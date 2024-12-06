package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void saveProduct(Product p) {
		int n=jdbcTemplate.update("insert into product values(?,?,?,?,?,?)", new Object[]{
				p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getLdt(),p.getCid()
		});
		

		
	}

}
