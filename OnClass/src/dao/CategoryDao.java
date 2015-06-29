package dao;


import java.io.Serializable;
import java.util.List;

import domain.*;

/**
 * 操作Category实体的Dao接口声明
 * @author root
 *
 */
public interface CategoryDao {

	/**
	 * 用于将一个Category对象保存到category表中
	 * @param category
	 */
	public void save(Category category);
	/**
	 * 更新
	 * @param category
	 */
	public void update(Category category);
	/**
	 * 删除制定编号的记录
	 * @param id
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据ID,获取一个分类信息
	 * @param id
	 * @return
	 */
	public Category findOne(Serializable id);
	
	/**
	 * 获取所有分类列表
	 * @return
	 */
	public List<Category> findAll();
}
