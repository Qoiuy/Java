package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import service.CustomerService;

public class CustomerSrviceImpl implements CustomerService{

	//业务逻辑层依赖于数据访问层
	private CustomerDao customerDao = new CustomerDaoImpl();
	public Customer login(String username, String password) {
		return customerDao.findCustomerByUsernameAndPwd(username, password);
	}

}
