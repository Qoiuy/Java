 package service.impl;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import domain.Book;
import service.BookService;
import utils.PageBean;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao = new BookDaoImpl();
      public void findBooksByCategoryIdAndPage(PageBean page, String categoryid) {
              //1.分页的总记录数
              int count = bookDao.findCountsByCatgoryid(categoryid);
              page.setTotalRecordes(count);//设置总记录数
              //2.当前页的记录
              List<Book> list = bookDao.findBooksByCategoryAndPage(page.getStartIndex(), page.getPageSize(), categoryid);
          page.setRecordes(list);//设置当前页的记录
      }
      
	@Override
	public Book findBookById(String id) {
		 return bookDao.findOne(id);	 
	}
	

}
