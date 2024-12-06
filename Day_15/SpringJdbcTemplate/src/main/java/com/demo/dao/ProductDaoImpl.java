package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	@Override
	public List<Product> findAll() {
		List<Product> plist=jdbcTemplate.query("select * from product", (rs,numrows)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setLdt(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			return p;
		});
		return plist;
	}

	@Override
	public Product findById(int pid) {
		try {
			Product p=jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid}, BeanPropertyRowMapper.newInstance(Product.class));
			return p;
		}catch(EmptyResultDataAccessException e) {
			System.out.println("in exception product not found");
			return null;
		}
	}

	@Override
	public List<Product> findByPrice(double price) {
		List<Product> plist=jdbcTemplate.query("select * from product where price>?",new Object[] {price}, BeanPropertyRowMapper.newInstance(Product.class));
		if(plist.size()>0)
			return plist;
		else
			return null;
				
	}

	@Override
	public boolean deleteById(int pid) {
		int n=jdbcTemplate.update("delete from product where pid=?",new Object[] {pid});
		return n>0;
	}

	@Override
	public boolean modifyById(int pid, int qty, double price) {
		int n=jdbcTemplate.update("update product set qty=?,price=? where pid=?",new Object[] {qty,price,pid});
		return n>0;
	}

}
