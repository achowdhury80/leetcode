package comp.prep2019.less1000;

public class Prob204 {
	/**
	 * O(nlogn)
	 * @param n
	 * @return
	 */
	public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
        	if (!notPrime[i]) {
        		result++;
        		for (int j = 2; i * (0l + j) < n; j++) {
        			notPrime[i * j] = true;
        		}
        	}
        }
        return result;
    }
}
