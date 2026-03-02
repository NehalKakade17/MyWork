package hardproblems;
import java.lang.reflect.Method;
public class Ref_inbuilt {

	public static void main(String[] args) {
		try {
			Class<?> cl = Class.forName("java.util.ArrayList");
			System.out.println(cl.getName());
			Class<?> scl = cl.getSuperclass();
			if(scl != null) {
				System.out.println(scl.getName());
			}
			else {
				System.out.println("No superclass");
			}
			Method [] m = cl.getDeclaredMethods();
			for(Method met : m) {
				System.out.println(met.getName());
			}
			System.out.println("Inherited methods:");
			Method[] superMethods = scl.getDeclaredMethods();
            for (Method method : superMethods) {
                System.out.println(method.getName());
            }
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
