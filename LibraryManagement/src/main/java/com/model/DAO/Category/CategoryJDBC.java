package com.model.DAO.Category;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.model.Category;

public class CategoryJDBC implements CategoryDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Category> getAll() {
		String sql = "SELECT * FROM Categories";
		try {
			List<Category> listCategory = jdbcTemplateObject.query(sql, new CategoryMapper());
			return listCategory;
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());			
			return null;
		}
	}

	@Override
	public int addCategory(Category category) {
		String SQL = "INSERT INTO Categories VALUES (?)";
		return jdbcTemplateObject.update(SQL, new Object[] { category.getName()});	
	}

	@Override
	public int updateCategory(Category category) {
		String SQL = "update Categories set Categories.Name = ? where Categories.Id =? ";
		return jdbcTemplateObject.update(SQL, new Object[] { category.getName(), category.getId()});	
	}

	@Override
	public int deleteCategory(int categoryId) {
		String SQL = "delete from Categories where Id = ?";
		return jdbcTemplateObject.update(SQL, new Object[] {categoryId});
	}

	@Override
	public Category getOne(int categoryId) {
		String sql = "SELECT * FROM Categories WHERE Id = ?";
		Category ct= (Category) jdbcTemplateObject.queryForObject(sql, new Object[]{categoryId} ,new CategoryMapper());
		return ct;
	}

	

}
