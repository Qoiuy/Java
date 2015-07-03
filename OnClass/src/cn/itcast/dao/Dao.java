package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;

import cn.itcast.domain.Category;

/**
 * 泛型接口
 * @author wangli
 *
 * @param <T>
 */
public interface Dao<T> {

	/**
	 * 用于将一个对象保存到数据库表中
	 * @param category
	 */
	public void save(T t);
	
	/**
	 * 更新
	 * @param cateogry
	 */
	public void update(T t );
	
	/**
	 * 删除指定编号的记录
	 * @param id
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据id,获限一个分类信息
	 * @param id
	 * @return
	 */
	public T findOne(Serializable id);
	
	/**
	 * 获取所有分类列表
	 * @return
	 */
	public List<T> findAll();
}
