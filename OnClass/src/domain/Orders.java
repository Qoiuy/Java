package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	
	public Orders() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Orders(String id, String ordernum, float price, int num, int status,
			Customer c, String customerid, List<OrdersItem> items) {
		super();
		this.id = id;
		this.ordernum = ordernum;
		this.price = price;
		this.num = num;
		this.status = status;
		this.c = c;
		this.customerid = customerid;
		this.items = items;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", ordernum=" + ordernum + ", price="
				+ price + ", num=" + num + ", status=" + status + ", c=" + c
				+ ", customerid=" + customerid + ", items=" + items + "]";
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public List<OrdersItem> getItems() {
		return items;
	}
	public void setItems(List<OrdersItem> items) {
		this.items = items;
	}
	private String id;
    private String ordernum;
    private float price;
    private int num;
    private int status;
    private Customer c;
    private String customerid;
    //这个代表一个订单下可以有多个订单项
    private List<OrdersItem> items = new ArrayList<OrdersItem>();

	
}
