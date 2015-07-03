package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.OrdersDao;
import cn.itcast.dao.impl.OrdersDaoImpl;
import cn.itcast.domain.Orders;
import cn.itcast.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	private OrdersDao ordersDao = new OrdersDaoImpl();
	public void addCascade(Orders orders) {
		ordersDao.save(orders);
	}
	public List<Orders> findOrdersByCustomerID(String id) {
		return ordersDao.findOrdersByCustomerID(id);
	}

}
