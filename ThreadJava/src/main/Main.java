package main;

import java.util.*;

public class Main {
	public static void main(String Args[]) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		executorService.execute(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task");
		    }
		});

		executorService.shutdown();
	}
}



