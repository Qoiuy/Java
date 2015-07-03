package cn.itcast.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.OrdersDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Orders;
import cn.itcast.domain.OrdersItem;
import cn.itcast.utils.C3P0Util;

public class OrdersDaoImpl implements OrdersDao {

	private QueryRunner qr  = new QueryRunner(C3P0Util.getDataSource());
	public void save(Orders t) {
		try {
			//保存了订单
			qr.update("insert into orders values(?,?,?,?,?,?)", t.getId(), t
					.getOrdernum(), t.getNum(), t.getPrice(), t.getStatus(), t
					.getC().getId());
			
			//级联保存明细
			List<OrdersItem> list = t.getItems();
			if(list!=null && list.size()>0){
				//有订单明细 
				for(OrdersItem oi :list){
					qr.update("insert into ordersitem values(?,?,?,?,?)", oi
							.getId(), oi.getNum(), oi.getPrice(), oi.getBook()
							.getId(), t.getId());
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void update(Orders t) {
		// TODO Auto-generated method stub

	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	public Orders findOne(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Orders> findOrdersByCustomerID(String id) {
		try {
			List<Orders> list =  qr.query("select * from orders where customerid=?",
					new BeanListHandler<Orders>(Orders.class), id);
			//级联加载
			for(Orders orders :list){
				Customer c= qr.query("select * from Customer where id=?", new BeanHandler<Customer>(Customer.class),orders.getCustomerid());
			    orders.setC(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
