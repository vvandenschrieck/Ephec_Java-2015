package thread;

public class Countdown extends Thread {
	public Countdown(String name){
		super(name);
	}
	public void run(){
		for(int i=5; i>=0; i--){
			String n = Thread.currentThread().getName();
			System.out.println (n + " : " + i);
			yield();

		}
	}
	public static void main(String []args){
		Countdown c1 = new Countdown("Thread 1");
		Countdown c2 = new Countdown("Thread 2");
		c1.start();
		
		c2.start();
	
	}
}
