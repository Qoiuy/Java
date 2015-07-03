package cn.itcast.web.form;

import java.util.HashMap;
import java.util.Map;

import cn.itcast.domain.Book;



/**
 * 购物车
 * @author wangli
 *传智.宋江
 */
public class Cart {
     private Map<String ,CartItem> map = new HashMap<String,CartItem>();
     private int totalNum;//总数量
     private double totalPrice;//总计
     
    public int getTotalNum() {
    	totalNum=0;
    	for(Map.Entry<String, CartItem> entry:map.entrySet()){
    		CartItem ci = entry.getValue();
    		totalNum+=ci.getNum();// 各数量之和形成总数量
    	}
 		return totalNum;
 	}
    
    public double getTotalPrice() {
    	totalPrice=0;
    	for(Map.Entry<String, CartItem> entry:map.entrySet()){
    		CartItem ci = entry.getValue();
    		totalPrice+=ci.getPrice();// 各数量之和形成总数量
    	}
		return totalPrice;
	}
    
    //添加图书时
    public void addBook2Cart(Book book,int num){
    	if(map.containsKey(book.getId())){
    		//说明这本书已存在，只要修改数量 
    		CartItem ci = map.get(book.getId());
    		ci.setNum(ci.getNum()+num);
    		//map.put(book.getId(), ci);//没有必要
    	}else{
    		//说明这本书不存在
    		CartItem ci =new CartItem();
    		ci.setBook(book);
    		ci.setNum(num);
    		//添加这个新条目到购物车中
    		map.put(book.getId(), ci);
    	}
    }
     
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
     
     
     
}
