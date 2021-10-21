package com.edureka.learningthread;

public class overriddingRunmethod extends Thread {
	
	public void run()
	{
		System.out.println("This is a thread");
	}

	public static void main(String[] args) {
		
		Thread th = new Thread();
		
		overriddingRunmethod orm = new overriddingRunmethod();
		orm.start();
	}

}
