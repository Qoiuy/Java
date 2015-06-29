package Thread;
/**
 * Thread.currentThread()方法
 * 返回当前进程的名称
 * Class.getName()方法
 * 返回线程的名称
 * */
//----------------------------------------------------------
/**/
/*
class Demo extends Thread{
	private String name;
	Demo(String name){
		super(name);
		this.name = name;
	}
	public void run(){
		for(int i = 0; i < 1000; i++){
			System.out.println(name + "...x=" + i +"...name" + Thread.currentThread().getName());
		}
	}
}

public class currentThread_demo {
	public static void main(String[] args){
		Demo d1 = new Demo("大黄");
		Demo d2 = new Demo("大白");
		
		d1.run();
		d1.start();
		d2.start();
		System.out.println("over" + "...name" + Thread.currentThread().getName());
		
	}
}
*/
/*
class Demo implements Runnable{
	private String name;
	Demo(String name){
		this.name = name;
	}
	public void run(){
		for(int i = 0; i < 1000; i++){
			System.out.println(name + "...x=" + i +"...name" + Thread.currentThread().getName());
		}
	}
}
public class currentThread_demo {
	public static void main(String[] args){
		Demo d1 = new Demo("大黄");
		Demo d2 = new Demo("大白");
		
		Thread t1 = new Thread(d1,"大黄");
		Thread t2 = new Thread(d2,"大白");
		
		t1.start();
		t2.start();
	}
}
*/