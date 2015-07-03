package cn.itcast.web.form;



import cn.itcast.domain.Category;
import cn.itcast.service.CategoryService;
import cn.itcast.service.impl.CategoryServiceImpl;

/**
 * 自定义EL的类
 * @author wangli
 *
 */
public class MyFunctions {

	public static String findCategoryNameByid(String id){
		CategoryService cs = new CategoryServiceImpl();
		Category category = cs.findCategoryById(id);//根据分类编号，得到分类对象
		return category.getName();
	}
}
