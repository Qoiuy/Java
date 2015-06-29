package domain;

public class Orders {
	public Orders() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Orders(String id, String ordernum, String num, String price,
			String status, String customerid) {
		super();
		this.id = id;
		this.ordernum = ordernum;
		this.num = num;
		this.price = price;
		this.status = status;
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", ordernum=" + ordernum + ", num=" + num
				+ ", price=" + price + ", status=" + status + ", customerid="
				+ customerid + "]";
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	private String id;
	private String ordernum;
	private String num;
	private String price;
	private String status;
	private String customerid;
	
}
