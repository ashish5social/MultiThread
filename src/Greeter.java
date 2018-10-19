import java.util.Random;

public class Greeter implements Runnable{
	String country; 
	Random rand; 
	public Greeter(String c) {
		country=c;
		rand = new Random(); 
	}
	
	
	@Override
	public void run() {
		int rand_int1 = rand.nextInt(10); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tName = Thread.currentThread().getName(); 
		//System.out.println("By thread "+tName+" : Printing "+country );
		for(int i=1; i<rand_int1; i++) {
			System.out.println("By thread "+tName+" : "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
