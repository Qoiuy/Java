package service;

import domain.Book;
import utils.PageBean;

public interface BookService {
	 /**
	 * 分页查询当前页的图书
	 * @param page
	 * @param categoryid
	 */
	 public void findBooksByCategoryIdAndPage(PageBean page,String categoryid);

	 /**
	  * 根据ID获得图书对象
	  * @param id
	  * @return
	  */
	 public Book findBookById(String id);

}
