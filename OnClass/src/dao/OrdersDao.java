package dao;

import java.util.List;

import domain.Orders;

public interface OrdersDao extends Dao<Orders> {
	 /**
     * 根据客户编号，得到一个订单列表
     * @param id
     * @return
     */

	List<Orders> findOrdersByCustomerID(String id);

}
