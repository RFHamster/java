<<<<<<< HEAD
package main;

	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;

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



=======
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



>>>>>>> 5698a5be944124ab2721a3e2786bca2ff6c42c3b
