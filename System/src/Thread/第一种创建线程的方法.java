package Thread;
/**
 * Thread.run方法
 * 创建一个线程
 * Thread.start方法
 * 执行run方法调用线程
 * 
 * 创建一个线程的第一种方法
 * 1.定义一个类继承Thread类
 * 2.覆盖Thread类中的run方法
 * 3.直接创建Thread的子类对象创建线程
 * 4.调用start方法开启线程并调用线程的任务run方法执行
 * */
//----------------------------------------------------------
/*
class Demo extends Thread{
	private String name;
	Demo(String name){
		this.name = name;
	}
	public void run(){
		for(int i = 0;i < 1000; i++){
			System.out.println(name + "...x=" + i);
		}
	}
}

public class 第一种创建线程的方法 {
	public static void main(String[] args){
		Demo d1 = new Demo("大黄");
		Demo d2 = new Demo("大白");
		
		d1.start();
		d2.start();
	}
}
*/
