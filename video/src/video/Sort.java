package video;

import java.util.ArrayList;

public class Sort {

	public static void main(String[] args) {

		int[] execution = {5, 3, 8, 6};
		int timeSlice = 3;
		double avgWait = 0;

		ArrayList<Integer> service = new ArrayList<>();
		int totalProcesses = execution.length;

		int[] remainingTime = new int[totalProcesses];
		System.arraycopy(execution, 0, remainingTime, 0, totalProcesses);

		int currentTime = 0;

		while (true) {
			boolean allProcessesCompleted = true;

			for (int i = 0; i < totalProcesses; i++) {
				if (remainingTime[i] > 0) {
					/**
					 * check if the process has been completed
					 */
					allProcessesCompleted = false;
					/**
					 * if the remaining time of the process is bigger than the time slice 
					 *  subtract from the remaining execution time the time slice and
					 * add the value of the time slice to the service time
					 */
					if (remainingTime[i] > timeSlice) {
						service.add(currentTime);
						currentTime += timeSlice;
						remainingTime[i] -= timeSlice;
					} else {
						/**
						 * if the remaining time of the process is smaller than the time slice
						 * add the value of the remaining time to the service and set the
						 * remaining time of the process to 0 
						 */
						service.add(currentTime);
						currentTime += remainingTime[i];
						remainingTime[i] = 0;
					}
				}
			}

			/**
			 * Exit from the while if the bool "allProcessesCompleted" is true
			 */

			if (allProcessesCompleted) {
				break;
			}
		}
		/**
		 * fill the arrive time array and calculate the wait time
		 */
		int[] arrive = new int [service.size()];
		int[] wait = new int [service.size()];
		for (int i = 0; i < service.size(); i++) {
			arrive[i]=i;
			wait[i] = service.get(i) - arrive[i];
		}
		/**
		 * calculate the avg wait
		 */
		for (int i = 0; i < service.size(); i++) {
			avgWait = avgWait + wait[i];
		}
		avgWait = avgWait / service.size();
		
		/**
		 *  Print the service times
		 */
		for (int i = 0; i < service.size(); i++) {
			System.out.println("service " + i + ": " + service.get(i));
		}
		System.out.println("the average wait is: "+avgWait);
	}
}
