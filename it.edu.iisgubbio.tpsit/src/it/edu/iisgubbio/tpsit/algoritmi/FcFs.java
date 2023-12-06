package it.edu.iisgubbio.tpsit.algoritmi;

public class FcFs {
	public static void main(String[] args) {
		
		String [] processo = new String [4];
		int [] arrivo = new int [4];
		int [] esecuzione = new int [4];
		int [] servizio = new int [4];
		int [] attesa = new int [4];
		
		double mediaAttesa;
		
		processo[0] = "P0";
		processo[1] = "P1";
		processo[2] = "P2";
		processo[3] = "P3";
		
		esecuzione[0] = 5;
		esecuzione[1] = 3;
		esecuzione[2] = 8;
		esecuzione[3] = 6;
		
		for(int x = 0; x<4; x++) {
			arrivo[x]=x;
		}
		
		for(int y = 0; y<4; y++) {
			if(y==0) {
				
				servizio[0]= 0;
				
				attesa[0]=0;
				
			}else {
				
				servizio[y]=servizio[y-1]+esecuzione[y-1];
				
				attesa[y] =  servizio[y]-arrivo[y];
			}
		}
		
		mediaAttesa =(double)(attesa[0]+attesa[1]+attesa[2]+attesa[3])/4;
		
		for(int i = 0; i<=3; i++) {
			System.out.println(processo[i]);
		}
		
		System.out.println("la media attesa è: "+mediaAttesa);
		
	}
}
