package it.edu.iisgubbio.tpsit.algoritmi;

public class Greedy {
	public static void main(String[] args) {
		String[] process = { "P0", "P1", "P2", "P3" };
		int[] result = new int [process.length]; 
		int[] gain = {100,10,15,27};
		int[] deadline = {2,1,2,1};
		
		/**
		 * order the gain, the process and the deadline arrays basing on the bigger to the smaller gain value
		 */
		//---------------------------------------------------------------------
		int last = gain.length - 1;

		for (int x = 0; x <= last - 1; x = x + 1) {
			for (int y = last - 1; y >= x; y--) {
				if (gain[y] < gain[y + 1]) {

					int saveGain = gain[y];
					String saveProcesso = process[y];
					int saveDeadline = deadline[y];
					
					gain[y] = gain[y + 1];
					process[y] = process[y + 1];
					deadline[y] = deadline[y + 1];
					
					gain[y + 1] = saveGain;
					process[y + 1] = saveProcesso;
					deadline[y + 1] = saveDeadline;
				}
			}
		}
		//---------------------------------------------------------------------
		/**
		 * fill the result array with 0 (0 means "empty slot")
		 */
		for(int i = 0; i<result.length; i++) {
			result[i]=0;
		}
		/**
		 * put the gain value into empty slot at the deadline index 
		 */
		for(int i = 0; i<result.length; i++) {
			
			if(result[deadline[i]] == 0) {
				result[i]=gain[i];
			}
		}
		
		/**
		 * print the result array
		 */
		
		for(int i = 0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
}
