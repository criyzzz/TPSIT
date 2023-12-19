package it.edu.iisgubbio.tpsit.algoritmi;

public class Priority {

	public static void main(String[] args) {

		String[] process = new String[4];
		int[] arrive = new int[4];
		int[] execution = new int[4];
		int[] service = new int[4];
		int[] wait = new int[4];
		int[] priority = new int[4];

		double mediaAttesa = 0;

		// insert the process and the execution time

		process[0] = "P0";
		process[1] = "P1";
		process[2] = "P2";
		process[3] = "P3";

		execution[0] = 5;
		execution[1] = 3;
		execution[2] = 8;
		execution[3] = 6;

		priority[0] = 1;
		priority[1] = 2;
		priority[2] = 1;
		priority[3] = 3;

		// automatically insert the arrive time

		for (int x = 0; x < 4; x++) {
			arrive[x] = x;
		}

		// order the arrive and the process and the execution time basing on the
		// priority
		// ---------------------------------------------
		int ultimo = priority.length - 1;

		for (int superficie = 0; superficie <= ultimo - 1; superficie = superficie + 1) {
			for (int posizione = ultimo - 1; posizione >= superficie; posizione--) {
				if (priority[posizione] < priority[posizione + 1]) {

					int appoggioPriority = priority[posizione];
					String appoggioProcesso = process[posizione];
					int appoggioArrivo = arrive[posizione];

					priority[posizione] = priority[posizione + 1];
					process[posizione] = process[posizione + 1];
					arrive[posizione] = arrive[posizione + 1];

					priority[posizione + 1] = appoggioPriority;
					process[posizione + 1] = appoggioProcesso;
					arrive[posizione + 1] = appoggioArrivo;
				}
			}
		}
		// ---------------------------------------------

		for (int y = 0; y < 4; y++) {
			// the service and the wait time of the P0 are 0 so is not necessary any
			// calculations

			if (y == 0) {

				service[0] = 0;

				wait[0] = 0;

			} else {

				// for the other process a I calculate the service and the wait time

				service[y] = service[y - 1] + execution[y - 1];

				wait[y] = service[y] - arrive[y];
			}
		}

		// calculate the average wait time
		for (int i = 0; i < process.length; i++) {

			mediaAttesa = mediaAttesa + wait[i];

		}

		mediaAttesa = mediaAttesa / process.length;

		for (int i = 0; i <= 3; i++) {
			System.out.println(process[i]);
		}

		System.out.println("processi");

		for (int i = 0; i <= 3; i++) {
			System.out.println(execution[i]);
		}

		System.out.println("esecuzioni");

		for (int i = 0; i <= 3; i++) {
			System.out.println(service[i]);
		}

		System.out.println("servizi");

		for (int i = 0; i <= 3; i++) {
			System.out.println(wait[i]);
		}

		System.out.println("attese");

		System.out.println("la media attesa è: " + mediaAttesa);

	}
}
