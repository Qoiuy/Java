package dao;

import java.util.List;

import domain.Orders;
import domain.OrdersItem;

public interface OrdersDao extends Dao<Orders> {
	 /**
     * 根据客户编号，得到一个订单列表
     * @param id
     * @return
     */

	List<Orders> findOrdersByCustomerID(String id);
	  /**
     * 根据流水号，修改订单状态 
     * @param r6_Order
     */
    void updateStatusByOrderNum(String r6_Order);
    /**
     * 根据订单号，得到它的明细列表
     * @param id
     * @return
     */
    List<OrdersItem> findOrdersItemByordersid(String id);

}
