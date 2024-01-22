package newThreads;

public class CustomThread extends Thread{

	public void run() {
		int[] v1 = new int[5]; 

		v1[0]=1;
		v1[1]=2;
		v1[2]=3;
		v1[3]=4;
		v1[4]=5;   
		

		for(int y = 1; y<=10; y++) {
			for(int i = 0; i<5; i++) {
				if(y==v1[i]) {
					System.out.println(y);
				}
			}
		}
	}
}
