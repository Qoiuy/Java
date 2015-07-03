package cn.itcast.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;
import cn.itcast.utils.C3P0Util;
/**
 * 分类的DAO
 * @author wangli
 *
 */
public class CategoryDaoImpl implements CategoryDao {

	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public void save(Category t) {
		// TODO Auto-generated method stub

	}

	public void update(Category t) {
		// TODO Auto-generated method stub

	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	public Category findOne(Serializable id) {
		try {
			return qr.query("select * from category where id=?" ,
					new BeanHandler<Category>(Category.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Category> findAll() {
		try {
			return qr.query("select * from category" ,
					new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
