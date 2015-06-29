package Object;
/*
 * Code1:equals方法的基本用法:
 * 比较2个对象是否相等，实际上比较2个对象的地址
 * Code2:equals实际应用
 * 比较本类中特有属性是否相同
 * */
//----------------------------------------------------------
/*
class Person{
	private int age;
	Person(int age){
		this.age = age;
	}
}
public class equals_demo {
	public static void main(String[] args){
		Person p1 = new Person(15);
		Person p2 = new Person(15);
		System.out.println(p1.equals(p2));//
		
		Person p3 = p1;
		System.out.println(p1.equals(p3));//
	}
}
*/
//----------------------------------------------------------
/*
class Person{
	private int age;
	Person(int age){
		this.age = age;
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Person)){
			return false;
			//throw new ClassCastException("类型错误");
		}
		Person p = (Person)obj;
		return this.age == p.age;
	}
}

public class equals_demo{
	public static void main(String[] args){
		Person p1 = new Person(15);
		
		Person p2 = new Person(15);
		System.out.println(p1.equals(p2));
	}
}*/