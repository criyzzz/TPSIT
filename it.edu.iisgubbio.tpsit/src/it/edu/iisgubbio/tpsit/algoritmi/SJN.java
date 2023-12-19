package it.edu.iisgubbio.tpsit.algoritmi;

// SJN (Shortest Job Next) is an algorithm that order the process and execute them basing
// on the lowest execution time

public class SJN {

	public static void main(String[] args) {

		int[] arrive = new int[4];
		int[] service = new int[4];
		int[] wait = new int[4];

		double avgWait = 0;

		/**
		 * insert the process and the execution time
		 */

		String[] process = { "P0", "P1", "P2", "P3" };

		int[] execution = { 5, 3, 8, 6 };

		/**
		 * automatically insert the arrive time
		 */

		for (int x = 0; x < 4; x++) {
			arrive[x] = x;
		}

		/**
		 * order the arrive and the process and the execution time
		 */
		// ---------------------------------------------
		int last = execution.length - 1;

		for (int x = 0; x <= last - 1; x = x + 1) {
			for (int y = last - 1; y >= x; y--) {
				if (execution[y] > execution[y + 1]) {

					int saveExecution = execution[y];
					String saveProcess = process[y];
					int saveArrive = arrive[y];

					execution[y] = execution[y + 1];
					process[y] = process[y + 1];
					arrive[y] = arrive[y + 1];

					execution[y + 1] = saveExecution;
					process[y + 1] = saveProcess;
					arrive[y + 1] = saveArrive;
				}
			}
		}
		// ---------------------------------------------

		for (int y = 0; y < 4; y++) {
			/**
			 * the service and the wait time of the P0 are 0 so is not necessary any
			 * calculations
			 */

			if (y == 0) {

				service[0] = 0;

				wait[0] = 0;

			} else {

				/**
				 * for the other process a I calculate the service and the wait time
				 */

				service[y] = service[y - 1] + execution[y - 1];

				wait[y] = service[y] - arrive[y];
			}
		}

		/**
		 * calculate the average wait time
		 */
		for (int i = 0; i < process.length; i++) {

			avgWait = avgWait + wait[i];

		}

		avgWait = avgWait / process.length;

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

		System.out.println("la media attesa è: " + avgWait);

	}
}
