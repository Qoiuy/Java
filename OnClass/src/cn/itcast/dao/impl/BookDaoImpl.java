package cn.itcast.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.utils.C3P0Util;

public class BookDaoImpl implements BookDao {

	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public void save(Book t) {
		// TODO Auto-generated method stub

	}

	public void update(Book t) {
		// TODO Auto-generated method stub

	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	public Book findOne(Serializable id) {
		try {
			return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int findCountsByCatgoryid(Serializable id) {
		try {
			return ((Long)qr.query("select count(*) from book where categoryid=?",new ScalarHandler(),id)).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Book> findBooksByCategoryAndPage(int startIndex, int pageSize,
			Serializable id) {
		try {
			return qr.query("select * from book  where categoryid=? limit ?,? ",new BeanListHandler<Book>(Book.class),id,startIndex,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
