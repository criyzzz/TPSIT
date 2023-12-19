package it.edu.iisgubbio.tpsit.algoritmi;

public class FcFs {
	public static void main(String[] args) {

		/**
		 * variable declaration
		 */

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
		 * automatically insert the arrive time (assuming the processes arrive in order)
		 */

		for (int x = 0; x < 4; x++) {
			arrive[x] = x;
		}

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

		System.out.println("AVG: " + avgWait);

	}
}
