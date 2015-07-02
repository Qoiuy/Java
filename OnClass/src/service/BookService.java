package service;

import utils.PageBean;

public interface BookService {
	 /**
	 * 分页查询当前页的图书
	 * @param page
	 * @param categoryid
	 */
	        public void findBooksByCategoryIdAndPage(PageBean page,String categoryid);

}
