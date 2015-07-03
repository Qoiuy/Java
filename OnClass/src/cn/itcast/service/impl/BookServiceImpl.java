package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.BookDao;
import cn.itcast.dao.impl.BookDaoImpl;
import cn.itcast.domain.Book;
import cn.itcast.service.BookService;
import cn.itcast.utils.PageBean;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	public void findBooksByCategoryIdAndPage(PageBean page, String categoryid) {
		//1.分页的总记录数
		int count = bookDao.findCountsByCatgoryid(categoryid);
		page.setTotalRecordes(count);//设置总记录数
		//2.当前页的记录
		List<Book> list = bookDao.findBooksByCategoryAndPage(page.getStartIndex(), page.getPageSize(), categoryid);
	    page.setRecordes(list);//设置当前页的记录
	}
	
	
	public Book findBookById(String id) {
		return bookDao.findOne(id);
	}

}
