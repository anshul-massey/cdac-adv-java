package com.cdac;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("productInventory3")
public class ProductInventoryImpl3 implements ProductInventory {

	@Autowired
	//TODO: Read about the importance of Connection Pooling
	private DataSource dataSource;
	
	@Override
	public void add(Product product) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
			String sql = "insert into tbl_product (name, price, quantity) values (?, ?, ?)";
			jt.update(sql, product.getName(), product.getPrice(), product.getQuantity());
	}

	@Override
	public List<Product> getAvailableProducts() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
			String sql = "select * from tbl_product";
			List<Product> list = jt.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
			return list;

	}

	
}
