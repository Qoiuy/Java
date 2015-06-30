package dao;

import java.io.Serializable;
import java.util.List;

/**
 * 操作实体的Dao接口声明
 * (将Dao接口抽取出来)
 * @author root
 *
 * @param <T>
 */
public interface Dao <T>{

	/**
	 * 用于将一个对象保存到数据库表中
	 * @param category
	 */
	public void save(T t);
	/**
	 * 更新
	 * @param category
	 */
	public void update(T t);
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
	public T findOne(Serializable id);
	
	/**
	 * 获取所有分类列表
	 * @return
	 */
	public List<T> findAll();
}
