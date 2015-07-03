package cn.itcast.utils;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

public class IDGenerator {

	public static String genID(){
		return UUID.randomUUID().toString();
	}
	
	public static String genCode(){
		BigInteger bigInt = new BigInteger(128, new Random());
		return bigInt.toString(36).toUpperCase();//26+10进制
	}
}
