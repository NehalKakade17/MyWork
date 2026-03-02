package multithreading;
class Q2
{
	int prodno ;

	void put(int x)
	{
		prodno = x;
		System.out.println("Produced : " + prodno);
	}

	void get()
	{
		System.out.println("Consumed : " + prodno);
	}
}

class Producers implements Runnable
{
	Q2 q;
	Thread t;

	public Producers(Q2 q)
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

class Consumers implements Runnable
{
	Q2 q;
	Thread t;

	public Consumers(Q2 q)
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

class ProducerConsumerProblemNonsynchronized
{
	public static void main(String args[]) throws InterruptedException
	{
		Q2 q = new Q2();
		Producers p = new Producers(q);
		Consumers c = new Consumers(q);

		p.t.join();
		c.t.join();
	}
}
