package com.model.DAO.Category;

import java.util.List;

import com.model.Category;

public interface CategoryDAO {
	public List<Category> getAll();
	public int addCategory(Category category);
	public int updateCategory(Category category);
	public int deleteCategory(int categoryId);
}
