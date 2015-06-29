package Thread;
/**
* 创建一个线程的第二种方法 实现Thread类的Runnable接口
* 1.定义类实现Runnable接口
* 2.覆盖接口中的run方法
* 3.通过thread类创建线程对象
* 4.将实现了Runnable接口的子类对象作为实际参数传递给Thread类中的构造函数
* 5.调用Thread对象的start方法
* */
//----------------------------------------------------------
/*
class Demo implements Runnable{
	public void run(){
		show();
	}
	private void show(){
		for(int i = 0;i < 1000;i++)
		System.out.println(Thread.currentThread().getName() + "..." +i);
	}
}

public class 第二种创建线程的方法 {
	public static void main(String[] args){
		Demo d = new Demo();
		
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		
		t1.start();
		t2.start();
	}
}*/
