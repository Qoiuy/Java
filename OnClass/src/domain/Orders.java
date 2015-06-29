package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	
	public Orders() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Orders(String id, String ordernum, int num, float price, int status,
			Customer c, List<Ordersitem> items) {
		super();
		this.id = id;
		this.ordernum = ordernum;
		this.num = num;
		this.price = price;
		this.status = status;
		this.c = c;
		this.items = items;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", ordernum=" + ordernum + ", num=" + num
				+ ", price=" + price + ", status=" + status + ", c=" + c
				+ ", items=" + items + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	public List<Ordersitem> getItems() {
		return items;
	}
	public void setItems(List<Ordersitem> items) {
		this.items = items;
	}
	private String id;
	private String ordernum;
	private int num;
	private float price;
	private int status;
	private Customer c;//这个代表一个订单下可以有多个订单项
	private List<Ordersitem> items = new ArrayList<Ordersitem>();
	
}
