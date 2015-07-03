package domain;

public class OrdersItem {
	                            
	public OrdersItem() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public OrdersItem(String id, int num, float price, Book book,
			String bookid, String ordersid) {
		super();
		this.id = id;
		this.num = num;
		this.price = price;
		this.book = book;
		this.bookid = bookid;
		this.ordersid = ordersid;
	}
	@Override
	public String toString() {
		return "Ordersitem [id=" + id + ", num=" + num + ", price=" + price
				+ ", book=" + book + ", bookid=" + bookid + ", ordersid="
				+ ordersid + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
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
	private int num;
	private float price;
	private Book book;
	private String bookid;
	private String ordersid;
}
