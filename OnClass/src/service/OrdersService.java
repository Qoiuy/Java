package service;

import java.util.List;

import domain.Orders;

public interface OrdersService {
	 /**
     * 级联保存，订单及订单明细
     * @param orders
     */
    void addCascade(Orders orders);

    /**
     * 根据客户编号，查询订单列表
     * @param id
     * @return
     */
    List<Orders> findOrdersByCustomerID(String id);

}
