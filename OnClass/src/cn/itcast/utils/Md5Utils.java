package cn.itcast.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import sun.misc.BASE64Encoder;

public class Md5Utils {

	/**
	 * 用于Md5加密的工具类
	 * @param oldString
	 * @return
	 */
	public static String encode(String oldString){
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			byte afterString [] = md5.digest(oldString.getBytes());//加密 
			//return new String(afterString);
			
			//将非ASCII码，转成ASCII码 ------------------》BASE64编码（64个字符构成）,它是ASCII码的一个子集
			BASE64Encoder b64 = new BASE64Encoder();
			return b64.encode(afterString);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Test//单元测试  公有的，无返回值，无参
	public void testMd5(){
		for (int i = 0; i < 20; i++) {
			System.out.println(Md5Utils.encode("bb"+i));
		}
	}
}
