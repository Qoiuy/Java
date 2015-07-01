package service.impl;

import org.junit.Test;

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

	@Override
	//更新
	public void update(Customer customer) {
		customer.setPassword(Md5Utils.encode(customer.getPassword()));
		customerDao.update(customer);	
	}

	@Override
	public void regist(Customer customer) {
		customer.setPassword(Md5Utils.encode(customer.getPassword()));
		customerDao.save(customer);		
	}
	@Test // 测试regist
	public void registtest(){
		Customer c = new Customer("3333","222","33333","男","1010255393@qq.com","1834726373","你好","你好",0,"0",0);
		regist(c);
	}

}

