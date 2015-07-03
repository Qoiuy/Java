package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;

import cn.itcast.domain.Customer;

public interface CustomerDao extends Dao<Customer> {

	/**
	 *登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Customer findCustomerByUsernameAndPwd(String username,String password);
}
