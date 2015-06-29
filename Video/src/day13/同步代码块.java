package day13;
/*
 *  同步代码块
 *  synchronized(对象){需要被同步的代码}
 *  任何对象都可以 这个对象就是锁
 * */
/*
class Ticket implements Runnable{
	private int num = 100;
	
	public void run(){
		sale();
	}
	
	Object obj = new Object();
	
	public void sale(){
		while(true){
			synchronized (obj) {
				if(num > 0){
					try{
					Thread.sleep(10);
					}
					catch(InterruptedException e ){	 
					}
					System.out.println(Thread.currentThread().getName()+ "卖出"+ (num--) +"号票");	
				}			
			}
		}
		
	}
}

public class 同步代码块 {
	public static void  main(String[] args){
		Ticket t = new Ticket();
		
		Thread t1 = new Thread(t,"一号窗口");
		Thread t2 = new Thread(t,"二号窗口");
		Thread t3 = new Thread(t,"三号窗口");
		Thread t4 = new Thread(t,"四号窗口");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
*/