package dao;

import java.io.Serializable;
import java.util.List;

import domain.Book;
		
public interface BookDao extends Dao<Book> {
	
	/**
	 * 得到某个分类下图书记录的总数
	 * @param id
	 * @return
	 */
	public int findCountsByCatgoryid(Serializable id);
		
	/**
     * 得到某个分类下，当前页的记录
     * @param startIndex
     * @param pageSize
     * @param id
     * @return
     */
    public List<Book> findBooksByCategoryAndPage(int startIndex,int pageSize,Serializable id);

}
