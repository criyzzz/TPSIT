package newThreads;

public class Main {
	public static void main(String args[]) {
		CustomThread c1 = new CustomThread();
		c1.start();
		
		CustomThread c2 = new CustomThread();
		c2.start();
	}
}
