package it.edu.iisgubbio.threads;

// Un thread in java può essere realizzato in vari modi:
// 1) faccio una classe che estende la classe nativa di java
// Thread che ha due metodi principali:
// start(): fa partire il thread
// run (): ncontiene il codice che deve essere eseguito dal thread 
public class HelloThreads extends Thread{

	public static void main (String args[]) {
		HelloThreads t1 = new HelloThreads();
		t1.start();
	}
	public void run() {
		System.out.println("Hello from a thread");
	}
	
}
