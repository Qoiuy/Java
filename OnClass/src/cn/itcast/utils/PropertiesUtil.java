package cn.itcast.utils;

import java.util.ResourceBundle;

public class PropertiesUtil {
	public static String getValue(String key){
		ResourceBundle rb = ResourceBundle.getBundle("merchantInfo");//国际化资源文件读取
		return rb.getString(key);
	}
}
