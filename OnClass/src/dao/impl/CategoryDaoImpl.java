package dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import utils.C3P0Utils;

import org.apache.commons.dbutils.QueryRunner;

import dao.CategoryDao;
import domain.Category;

public class CategoryDaoImpl implements CategoryDao {

	//private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());//用于执行CURL命令
	
	private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public void save(Category category) {
		//PreparedStatement 预处理 sql语句中有?作为占位符  
		try {
			qr.update("insert into category values(?,?,?)",category.getId(),category.getName(),category.getDescription());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void update(Category category) {
		try {
			qr.update("update category set name = ?,description=? where id = ?",category.getName(),category.getDescription(),category.getId());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void delete(Serializable id) {
		try {
			qr.update("delete from category where id=?",id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException();
		}		
	}

	@Override
	public Category findOne(Serializable id) {
				return null;
	}

	@Override
	public List<Category> findAll() {
				return null;
	}

}
