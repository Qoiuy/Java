package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Category;

public interface CategoryService {

	/**
	 * 查询所有的分类列表
	 * @return
	 */
	public List<Category> findAll();

	/**
	 * 根据分类id,得到一个分类的对象
	 * @param id
	 * @return
	 */
	public Category findCategoryById(String id);
}
