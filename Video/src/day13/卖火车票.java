package day13;
//存在问题
/*class Ticket implements Runnable{
	private int num = 100;
	
	public void run(){
		sale();
	}
	
	public void sale(){
		while(true){
			if(num > 0){
//				try{
//					Thread.sleep(10);
//				}
//				catch(InterruptedException e ){	 
//				}
				System.out.println(Thread.currentThread().getName()+ "卖出"+ (num--) +"号票");
				
			}
		}
		
	}
}

public class 卖火车票 {
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