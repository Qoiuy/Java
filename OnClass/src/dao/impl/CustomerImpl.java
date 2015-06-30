package dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.C3P0Utils;
import dao.CustomerDao;
import domain.Customer;

public class CustomerImpl implements CustomerDao {

	private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public void save(Customer t) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void update(Customer t) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void delete(Serializable id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Customer findOne(Serializable id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO 自动生成的方法存根
		return null;
	}
	
	/**
	 * 登录 select------->ResultSer(一条记录)--->BeanHandler起转换作用-->Customer对象
	 * 登录 select------->ResultSer(多条记录)--->BeanListHandler起转换作用-->Customer对象
	 * @param username
	 * @param password
	 * @return
	 */
	public Customer findCustomerByUsernameAndPwd(String username, String password){
		try {
			return qr.query("select * from customer where username=? and password=?",
					 new BeanHandler<Customer>(Customer.class),username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
