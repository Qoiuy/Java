package web.form;

import domain.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

/**
 * 自定义EL类
 * @author root
 *
 */
public class MyFunctions {
	  public static String findCategoryNameByid(String id){
          CategoryService cs = new CategoryServiceImpl();
          Category category = cs.findCategoryById(id);//根据分类编号，得到分类对象
          return category.getName();
  }

}
