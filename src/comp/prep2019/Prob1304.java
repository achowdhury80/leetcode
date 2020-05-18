package comp.prep2019;

public class Prob1304 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public int[] sumZero(int n) {
        int[] result = new int[n];
        int i = 1, idx = 0;
        while(n > 1) {
        	result[idx++] = i;
        	result[idx++] = -i;
        	i++;
        	n -= 2;
        }
        if (n > 0) result[idx++] = 0;
        return result;
    }
}
