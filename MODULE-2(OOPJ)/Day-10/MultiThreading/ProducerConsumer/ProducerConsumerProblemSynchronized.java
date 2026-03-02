package multithreading;
class Q
{
	int prodno ;
	boolean valSet;

	synchronized void put(int x)
	{
		try
		{
			if(valSet == true)
				wait();
				
			prodno = x;
			System.out.println("Produced : " + prodno);
			valSet = true;
			notify();
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}

	synchronized void get()
	{
		try
		{
			if(valSet == false)
				wait();
				
			System.out.println("Consumed : " + prodno);
			valSet = false;
			notify();
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}

class Producer implements Runnable
{
	Q q;
	Thread t;

	public Producer(Q q)
	{
		this.q = q;
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		produce();
	}

	void produce()
	{
		for(int i = 1; i <= 10; i++)
		{
			q.put(i);
		}

	}


}

class Consumer implements Runnable
{
	Q q;
	Thread t;

	public Consumer(Q q)
	{
		this.q = q;
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		consume();
	}

	void consume()
	{
		for(int i = 1; i <= 10; i++)
		{
			q.get();
		}
	}
}

class ProducerConsumerProblemSynchronized
{
	public static void main(String args[]) throws InterruptedException
	{
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);

		p.t.join();
		c.t.join();
	}
}
