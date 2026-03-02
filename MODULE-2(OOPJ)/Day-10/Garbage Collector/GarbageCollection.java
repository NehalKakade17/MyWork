package garbage;
class One
{
	Two t;
	
	protected void finalize()
	{
		System.out.println("Garbage collection initiated for an object of One");
	}
}

class Two
{
	One o;
	
	protected void finalize()
	{
		System.out.println("Garbage collection initiated for an object of Two");
	}
}

class Demo
{
	String name;
	
	Demo()
	{
	}
	
	Demo(String name)
	{
		this.name = name;
	}
	
	protected void finalize()
	{
		System.out.println("Garbage collection initiated for : " + this.name);
	}
}
public class GarbageCollection {
	public static void myFun()
	{
		Demo d6 = new Demo("Six");
		
	}
	public static void main(String[] args) {
		Demo d1 = new Demo("First");
		Demo d2 = new Demo("Second");
		
		d1 = d2;
		Demo d3 = new Demo("Third");
		d3 = d1;

		Demo d4 = new Demo("Four");
		d4 = null;

		new Demo("Five");
						
		myFun();
		
		One oneObj = new One();
		Two twoObj = new Two();
		
		oneObj.t = twoObj;
		twoObj.o = oneObj;

		oneObj = null;
		twoObj = null;
		
		//System.gc();
		Runtime.getRuntime().gc();
		System.out.println("Program terminated successfully");

	}

}
