package classlevellock;


class Display
{
	
	public void wish(String name)
	{
		synchronized (this){
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

class Mythread extends Thread
{
	Display d;
	String name;
	public Mythread(Display d, String name) {
		this.d=d;this.name=name;
	}
	public void run ()
	{
		d.wish(name);
	}
}
public class ClasslevelLock2 {

	public static void main(String[] args) {
		Display d1= new Display();
		Display d2= new Display();
		Mythread t1= new Mythread(d1,"dhoni");
		Mythread t2= new Mythread(d2,"YovRaj");
		t1.start();
		t2.start();
		// Solution = ClasslevelLock3.java
	}

}
