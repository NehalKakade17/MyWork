package multithreading;
class StringPrinters
{
	public void printStr(String str)
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


class MyThread4 implements Runnable
{
	Thread t;
	StringPrinters sp;
	String msgToPrint;
	
	MyThread4()
	{
		t = new Thread(this);
		t.start();
	}
	
	MyThread4(StringPrinters sp, String msgToPrint)
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


class NonsynchronizedDemo
{
	public static void main(String args[]) throws InterruptedException
	{
		StringPrinters sp = new StringPrinters();
		
		MyThread4 mt1 = new MyThread4(sp,"Hello");
		MyThread4 mt2 = new MyThread4(sp,"Friends");
		MyThread4 mt3 = new MyThread4(sp,"Welcome");
		
		mt1.t.join();	//Main thread pauses its execution for mt1 to complete its task.
		mt2.t.join();	//Main thread pauses its execution for mt2 to complete its task.
		mt3.t.join();
		
		System.out.println("Main thread completed");
	}
	
			
}
