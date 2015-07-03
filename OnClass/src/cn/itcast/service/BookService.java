package cn.itcast.service;

import cn.itcast.domain.Book;
import cn.itcast.utils.PageBean;

public interface BookService {
	 /**
	 * 分页查询当前页的图书
	 * @param page
	 * @param categoryid
	 */
	public void findBooksByCategoryIdAndPage(PageBean page,String categoryid);

	/**
	 * 根据id,获得图书对象
	 * @param id
	 * @return
	 */
	public Book findBookById(String id);
}
