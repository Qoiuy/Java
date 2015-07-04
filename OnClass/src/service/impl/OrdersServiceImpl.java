package service.impl;

import java.util.List;

import dao.OrdersDao;
import dao.impl.OrdersDaoImpl;
import service.OrdersService;
import domain.Orders;

public class OrdersServiceImpl implements OrdersService {
	  private OrdersDao ordersDao = new OrdersDaoImpl();
      public void addCascade(Orders orders) {
              ordersDao.save(orders);
      }
     
	@Override
	public List<Orders> findOrdersByCustomerID(String id) {
		 return ordersDao.findOrdersByCustomerID(id);
	}
	
	 public void updateStatusByOrderNum(String r6_Order) {
         ordersDao.updateStatusByOrderNum(r6_Order);

	 }

}
