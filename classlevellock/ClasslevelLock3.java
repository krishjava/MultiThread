package classlevellock;

class Displays
{
	
	public void wish(String name)
	{
		synchronized (Displays.class){
			for (int i=0; i< 10; i++)
			{
				System.out.print("good Morning : ");
				try {
					
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				
			}
				System.out.println(name);
			}
		}
	}
}

class Mythreads extends Thread
{
	Displays d;
	String name;
	public Mythreads(Displays d, String name) {
		this.d=d;this.name=name;
	}
	public void run ()
	{
		d.wish(name);
	}
}
public class ClasslevelLock3 {

	public static void main(String[] args) {
		Displays d1= new Displays();
		Displays d2= new Displays();
		Mythreads t1= new Mythreads(d1,"dhoni");
		Mythreads t2= new Mythreads(d2,"YovRaj");
		t1.start();
		t2.start();
		// Solution = ClasslevelLock3.java
	}

}
