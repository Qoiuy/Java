package domain;

public class Ordersitem {
	public Ordersitem() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Ordersitem(String id, String num, String price, String bookid,
			String ordersid) {
		super();
		this.id = id;
		this.num = num;
		this.price = price;
		this.bookid = bookid;
		this.ordersid = ordersid;
	}
	@Override
	public String toString() {
		return "Ordersitem [id=" + id + ", num=" + num + ", price=" + price
				+ ", bookid=" + bookid + ", ordersid=" + ordersid + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}
	private String id;
	private String num;
	private String price;
	private String bookid;
	private String ordersid;
}
