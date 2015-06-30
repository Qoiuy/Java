package service;

import domain.Customer;

/**
 * Customer对应的业务逻辑
 * @author root
 *
 */
public interface CustomerService {

	/**
	 * 登录
	 * @param username
	 * @param paddword
	 * @return
	 */
	public Customer login(String username, String password);
}
