package multithreading;
class MyThreads implements Runnable
{
	Thread t ;
	public MyThreads(ThreadGroup tGroup,String tName)
	{
		t = new Thread(tGroup,this,tName);
	}

	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " from ThreadGroup: " + t.getThreadGroup().getName() + " started running ");
		try {
			while(true)
			{
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName() + " is running ");
			}
		}
		catch (InterruptedException e)
		{
			System.out.println(Thread.currentThread().getName() + " is interrupted ");
		}
	}
}
public class ThreadGroupDemo {
	public static void main(String args[])
	{
		ThreadGroup tgroup = new ThreadGroup("Group Nehal");
		MyThreads t1 = new MyThreads(tgroup,"Thread1");
		MyThreads t2 = new MyThreads(tgroup,"Thread2");
		MyThreads t3 = new MyThreads(tgroup,"Thread3");
		t1.t.start();
		t2.t.start();
		t3.t.start();
		try
		{
			System.out.println("Current thread: " + Thread.currentThread().getName());
			Thread.sleep(2000);
			tgroup.interrupt();		//Will cause InterruptedException
			
			//It will interrupt all the threads inside the group and will force them to terminate.
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
	}
}
