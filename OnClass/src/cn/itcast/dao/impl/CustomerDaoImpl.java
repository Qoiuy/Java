package cn.itcast.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.utils.C3P0Util;

public class CustomerDaoImpl implements CustomerDao {

	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	public void save(Customer t) {
		try {
			String sql= "insert into customer values(?,?,?,?,?,?,?,?,?,?,?)";
			qr.update(sql, t.getId(),t.getUsername(),t.getPassword(),t.getSex(),t.getTelephone(),t.getDescription(),
					t.getAddress(),t.getActived(),t.getCode(),t.getRole(),t.getEmail());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void update(Customer t) {
		try {
			String sql = "update customer set username=?, password=?,sex=?,telephone=?" +
					",description=?,address=?,actived=?,code=?,role=?,email=? where id=?";
			qr.update(sql, t.getUsername(),t.getPassword(),t.getSex(),t.getTelephone(),t.getDescription(),
					t.getAddress(),t.getActived(),t.getCode(),t.getRole(),t.getEmail(),t.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	public Customer findOne(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 登录  select------------>ResultSet(一条记录)-----BeanHandler起转换作用------>Customer对象
	 *      select ----------->ResultSet(多条记录）----BeanListHandler起转换作用---->List<Customer>对象
	 */
	public Customer findCustomerByUsernameAndPwd(String username,String password){
		try {
			return qr.query("select * from customer where username=? and password=? and actived=1" ,
					new BeanHandler<Customer>(Customer.class),username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
				
	}

}
