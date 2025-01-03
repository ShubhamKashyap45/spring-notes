package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
   JdbcTemplate jdbcTemplate;

	//@Override
	public MyUser validateUser(String unm, String passwd) {
		try {
		return jdbcTemplate.queryForObject("select uname,password,role from user where uname=? and password=?",
				new Object[]{unm,passwd},BeanPropertyRowMapper.newInstance(MyUser.class));
		}catch(EmptyResultDataAccessException e) {
			System.out.println("user not found");
			return null;
		}
		
	}
}
