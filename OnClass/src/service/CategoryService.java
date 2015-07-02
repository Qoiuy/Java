package service;

import java.util.List;

import domain.Category;

/**
 * Category对应的业务逻辑
 * @author root
 *
 */
public interface CategoryService {	
	/**
	 * 查询所有的分类列表
	 * @return
	 */
	public List<Category> findAll();

}
