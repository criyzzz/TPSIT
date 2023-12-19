package it.edu.iisgubbio.tpsit.algoritmi;

import java.util.ArrayList;

public class RoundRobin {
	
	int timeSlice = 3;
	
	static int[] execution = new int[4];
	
	 static ArrayList<Integer> service = new ArrayList<Integer>();
	 
	 static boolean primo = true;
	 
	static void execution() {
		for(int i = 0; i<4; i++){
			if (execution[i]>=3) {
				execution[i]-=3;
				if(primo) {
					service.add(3);
					primo = false;
				}else {
					service.add(service.get(i-1)+3);
				}
				
				
			}else {
				if (execution[i]==2) {
					execution[i]-=2;
					if(primo) {
						service.add(2);
						primo = false;
					}else {
						service.add(service.get(i-1)+2);
					}
					
				}else {
					if(execution[i]==1) {
						execution[i]-=1;
						if(primo) {
							service.add(1);
							primo = false;
						}else {
							service.add(service.get(i-1)+1);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		String[] process = new String[4];
		
		process[0] = "P0";
		process[1] = "P1";
		process[2] = "P2";
		process[3] = "P3";
		
		execution[0] = 5;
		execution[1] = 3;
		execution[2] = 8;
		
		execution[3] = 6;
		
		execution();
		execution();
		
		 for(int i = 0; i<4; i++) {
			 System.out.println("esecuzione: "+execution[i]);
		 }
		 
		 for(int i = 0; i<4; i++) {
			 System.out.println("servizio: "+service.get(i));
		 }

	}
}
