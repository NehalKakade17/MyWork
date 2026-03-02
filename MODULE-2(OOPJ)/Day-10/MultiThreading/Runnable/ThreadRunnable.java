package multithreading;
class MyThread implements Runnable
{
	Thread t;
	
	MyThread()
	{
		t = new Thread(this);
		t.start();
	}
	
	MyThread(String tname)
	{
		t = new Thread(this,tname);
		t.start();
	}
	
	public void run() 
	{
		try
		{
			//System.out.println(this.getName() + " thread started");
			System.out.println(Thread.currentThread().getName() + " thread started");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " thread completed");
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}
public class ThreadRunnable {
	public static void main(String args[]) throws InterruptedException
	{
		MyThread mt1 = new MyThread("First");
		
		//mt1.t.setName("First");
		//mt1.t.start();
		
		MyThread mt2 = new MyThread("Second");
		
		//Thread.sleep(2000);	//Main thread is sleeping here for 2 second
		
		mt1.t.join();	//Main thread pauses its execution for mt1 to complete its task.
		mt2.t.join();	//Main thread pauses its execution for mt2 to complete its task.
		
		System.out.println("Main thread completed");
	}
}
