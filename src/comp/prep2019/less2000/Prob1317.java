package comp.prep2019.less2000;

public class Prob1317 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public int[] getNoZeroIntegers(int n) {
       for (int i = 1; i <= n / 2; i++) {
    	   if (("" + i).indexOf('0') < 0 && ("" + (n - i)).indexOf('0') < 0) 
    		   return new int[] {i, n - i};
       }
       return new int[0]; 
    }
}
