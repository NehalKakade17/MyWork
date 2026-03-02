package hardproblems;
import java.lang.reflect.Method;
public class Reflect_local {
	static class Local{
		void print() {
	}
		void record() {
			
		}
	}
	public static void main(String[] args) {
		Class<?> cl = Local.class;
		System.out.println("Class: "+cl.getName());
		Class<?> scl = cl.getSuperclass();
		if(scl != null) {
		System.out.println("SuperClass: "+scl.getName());
		}
		else {
			System.out.println("No SuperClass..");
		}
		System.out.println("Methods-");
		Method[] meth = cl.getDeclaredMethods();
		for(Method m : meth) {
			System.out.println(m.getName());
		}
		System.out.println("Inherited Methods-");
		Method[] method = scl.getDeclaredMethods();
		for(Method m : method) {
			System.out.println(m.getName());
		}
		
		

	}

}
