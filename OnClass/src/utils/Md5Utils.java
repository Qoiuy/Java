package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import sun.misc.BASE64Encoder;
/**
 * 用于Md5加密的工具类
 * @author root
 *
 */
public class Md5Utils {

	public static String encode(String oldString){
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			byte afterString [] = md5.digest(oldString.getBytes());
			//return new String(afterString);
			
			//将非ascii码，转成ascii码-------------base64编码()
			BASE64Encoder b64 = new BASE64Encoder();
			return b64.encode(afterString);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Test //单元测试 
	public void testMd5(){
		for(int i = 0;i <200; i++)
		{
			System.out.println(Md5Utils.encode("123"));
		}
	}
	
}
