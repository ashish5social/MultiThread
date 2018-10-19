public class Table{  

void printTable(int n){//method not synchronized  
   for(int i=1;i<=5;i++){  
     System.out.println(n*i);  
     try{  
      Thread.sleep(400);  
     }catch(Exception e){System.out.println(e);}  
   }  
  
 }

synchronized void printTableSynchronized(int n){//method not synchronized  
	   for(int i=1;i<=5;i++){  
	     System.out.println(n*i);  
	     try{  
	      Thread.sleep(400);  
	     }catch(Exception e){System.out.println(e);}  
	   }  
	  
	 }  

//In place of making method itself as synchronized, one can make a block of code as synchronized(this){ 
// Lines of Code to synchronize} 
//void printTable(int n){  
//	   synchronized(this){//synchronized block  
//	     for(int i=1;i<=5;i++){  
//	      System.out.println(n*i);  
//	      try{  
//	       Thread.sleep(400);  
//	      }catch(Exception e){System.out.println(e);}  
//	     }  
//	   }  
//	}//end of the method  


} 





//Suppose there are two objects of a shared class(e.g. Table) named object1 and object2.In case of synchronized method and synchronized block there cannot be interference between t1 and t2 or t3 and t4 because t1 and t2 both refers to a common object that have a single lock.But there can be interference between t1 and t3 or t2 and t4 because t1 acquires another lock and t3 acquires another lock.I want no interference between t1 and t3 or t2 and t4.Static synchronization solves this problem.
//synchronized static void printTable(int n){  
//	   for(int i=1;i<=10;i++){  
//	     System.out.println(n*i);  
//	     try{  
//	       Thread.sleep(400);  
//	     }catch(Exception e){}  
//	   }  
//	 }  
//	}  

// Then call this method from thead class's run as Table.printTable() 