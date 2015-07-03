package cn.itcast.web.form;

import cn.itcast.domain.Book;


/**
 * 购物明细
 * @author wangli
 *传智.宋江
 */
public class CartItem {
    private Book book ;
    private int num;//数量
    private double price;//小计
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {//=======================要注意哦！！！
		return book.getPrice()*num;
	}
	public void setPrice(double price) {
		this.price = price;
	}
   
   
}
