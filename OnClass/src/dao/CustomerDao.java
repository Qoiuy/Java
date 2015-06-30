package dao;

import domain.Customer;

public interface CustomerDao extends Dao<Customer> {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Customer findCustomerByUsernameAndPwd(String username, String password);
		
}
