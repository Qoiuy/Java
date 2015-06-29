package Object;
/*
 * Object finalize方法
 * 当垃圾回收器确定不存在的该对象的更多引用时，由垃圾回收器调用此方法
 * */
//----------------------------------------------------------
/*
class Person{
	public void finalize(){
		System.out.println("重写object.fianlize");
	}
}

public class finalize_demo {
	public static void main(String[] args){
		new Person();
		System.gc();//调用系统的垃圾回收器
		//System.out.println("hello ~~~~~~~~");
	}
}
*/