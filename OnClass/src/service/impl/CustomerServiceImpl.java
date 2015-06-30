package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import service.CustomerService;
import utils.Md5Utils;

public class CustomerServiceImpl implements CustomerService{

	//业务逻辑层依赖于数据访问层
	private CustomerDao customerDao = new CustomerDaoImpl();
	
	public Customer login(String username, String password) {
		//在业务逻辑层中放入加密操作
		password = Md5Utils.encode(password);
		return customerDao.findCustomerByUsernameAndPwd(username, password);
	}

}
