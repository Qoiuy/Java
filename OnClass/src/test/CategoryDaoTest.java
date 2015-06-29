package test;

import org.junit.Test;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;


public class CategoryDaoTest {
	
	@Test //注解 Jnuit单元的注解
	public void  testAdd(){
		CategoryDao dao = new  CategoryDaoImpl();
		Category c = new Category("123456","仅凭眉","价格还可以");
		dao.save(c);
	}
	
	@Test //注解 Jnuit单元的注解
	public void  testUpdate(){
		CategoryDao dao = new  CategoryDaoImpl();
		Category c = new Category("123456","菊花标点","你妈好贵");
		dao.update(c);
	}
	
	@Test //注解 Jnuit单元的注解
	public void  testDelete(){
		CategoryDao dao = new  CategoryDaoImpl();
		dao.delete("123456");
	}
	
}
