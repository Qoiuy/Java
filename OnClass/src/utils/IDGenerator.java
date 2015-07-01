package utils;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

public class IDGenerator {
	/**
	 * 产生一个随机ID
	 * @return
	 */
	public static String genID(){
//		String ls = UUID.randomUUID().toString();
//
//		System.out.println(ls);
//		return ls;
		return UUID.randomUUID().toString();
		
	}
	public static String genCode(){
		BigInteger bigInt = new BigInteger(128,new Random());
		return bigInt.toString(36).toUpperCase();//
	}
}
