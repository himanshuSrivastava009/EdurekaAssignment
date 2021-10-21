package com.edureka.learningthread;

public class ImplementingRunnableInterface implements Runnable  {

	public static void main(String[] args) {

		
		ImplementingRunnableInterface iri = new ImplementingRunnableInterface();
		Thread th = new Thread(iri);
		th.start();
		System.out.println(th.getName());
		
		
	}

	@Override
	public void run() {
		System.out.println("This is a thread");
		
	}
	
	

}


class A  implements Runnable
{
	public void run()
	{
		
	}
}

class B extends A implements Runnable
{
	public void run()
	{
		
	}
}
