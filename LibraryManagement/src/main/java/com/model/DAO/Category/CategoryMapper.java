package com.model.DAO.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Category;

public class CategoryMapper implements RowMapper<Category>{
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException{
		Category category = new Category();
		category.setId(rs.getInt(1));
		category.setName(rs.getString(2));		
		return category;
	}
}
