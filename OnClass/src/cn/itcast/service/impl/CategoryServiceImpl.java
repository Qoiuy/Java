package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.CategoryDao;
import cn.itcast.dao.impl.CategoryDaoImpl;
import cn.itcast.domain.Category;
import cn.itcast.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao = new CategoryDaoImpl();
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	public Category findCategoryById(String id) {
		return categoryDao.findOne(id);
	}

}
