package multithreading;
class StringPrinter
{
	synchronized public void printStr(String str)
	{
		try
		{
			System.out.print("[");
			Thread.sleep(500);		//does not release lock
			System.out.print(str);
			Thread.sleep(500);
			System.out.print("]");
			Thread.sleep(500);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}


class MyThread3 implements Runnable
{
	Thread t;
	StringPrinter sp;
	String msgToPrint;
	
	MyThread3()
	{
		t = new Thread(this);
		t.start();
	}
	
	MyThread3(StringPrinter sp, String msgToPrint)
	{
		this.sp = sp;
		this.msgToPrint = msgToPrint;
		
		t = new Thread(this);
		t.start();
	}
	
	public void run() 
	{
		sp.printStr(msgToPrint);
	}
}


class SynchronizedDemo
{
	public static void main(String args[]) throws InterruptedException
	{
		StringPrinter sp = new StringPrinter();
		
		MyThread3 mt1 = new MyThread3(sp,"Hello");
		MyThread3 mt2 = new MyThread3(sp,"Friends");
		MyThread3 mt3 = new MyThread3(sp,"Welcome");
		
		mt1.t.join();	//Main thread pauses its execution for mt1 to complete its task.
		mt2.t.join();	//Main thread pauses its execution for mt2 to complete its task.
		mt3.t.join();
		
		System.out.println("Main thread completed");
	}
	
			
}
