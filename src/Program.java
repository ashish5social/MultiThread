import java.util.ArrayList;

public class Program {

	public static void main1(String[] args) {
		String countries[] = {"India", "China", "USA", "Germany", "France"};
		int counter = 0;
		ArrayList<Thread> listOfThreads = new ArrayList<Thread>(); 
		for(String c : countries) {
			Greeter g = new Greeter(c);
			Thread t = new Thread(g, "Thread"+counter++ +"ForCountry"+c);
			listOfThreads.add(t); 
//			t.start();
		}
		//Here I have all threads in new state 
//		for(Thread thread : listOfThreads) {
//			System.out.println("Thread "+thread.getName()+" is Alive?" + thread.isAlive() +" and state is "+thread.getState()); 
//			thread.start();
//		}

		//while(!isAllThreadDead(listOfThreads)) {
		for(Thread thread : listOfThreads) {
			if(thread.getName().contains("India")) {
				thread.start();
//				thread.join();
			}
			
			System.out.println("A: Thread "+thread.getName()+" is Alive?" + thread.isAlive() +" and state is "+thread.getState()); 
		}

		for(Thread thread : listOfThreads) {
			if(thread.getName().contains("India")) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//	System.out.println("B: Thread "+thread.getName()+" is Alive?" + thread.isAlive() +" and state is "+thread.getState());
		}
	
		
		for(Thread thread : listOfThreads) {
			if(!thread.getName().contains("India")) {
				thread.start();
			}
			//System.out.println("B: Thread "+thread.getName()+" is Alive?" + thread.isAlive() +" and state is "+thread.getState());
		}
		
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//}

		 
		
	}

	private static boolean isAllThreadDead(ArrayList<Thread> listOfThreads) {
		 
		for(Thread t : listOfThreads) {
			if(t.isAlive()) {
				return false; 
			}
		}
		System.out.println("All threads are now terminated");
		return true; 
	}
	
	public static void main(String[] args) throws InterruptedException {
		Table obj = new Table();//only one object  
		MyThread1 t1=new MyThread1(obj);   //Both these threads are using same object 
		MyThread2 t2=new MyThread2(obj);   //So the method is not executed first for one thread
		t1.start();  
		//t1.join();
		t2.start();  //Output is like 5 100 10 200 300.. So if we add t1.join() then first t1 willfinish
		//t2.join();
		
		//Either you join for a thread that means that thread first finish then only the control will move ahead
		//or make the method which is critical section as synchronized 
		//When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.
	
		
		
	}
	

}

class MyThread1 extends Thread{  
Table t;  
MyThread1(Table t){  
this.t=t;  
}  
public void run(){  
t.printTableSynchronized(5);  
}  
  
}  
class MyThread2 extends Thread{  
Table t;  
MyThread2(Table t){  
this.t=t;  
}  
public void run(){  
t.printTableSynchronized(100);  
}  
}  