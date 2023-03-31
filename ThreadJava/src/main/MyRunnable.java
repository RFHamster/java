package main;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Math.random() % 10);
		
	}
	
}
