package comp.prep2019.less1000;

public class Prob995 {
	/**
	 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/
	 * @param A
	 * @param K
	 * @return
	 */
	public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int result = 0, flip = 0;
        int[] hint = new int[n];
        for (int i = 0; i < n; i++) {
        	flip ^= hint[i];
        	if (A[i] == flip) {
        		result++;
        		if (i + K > n) return -1;
        		flip ^= 1;
        		if (i + K < n) hint[i + K] ^= 1;
        	}
        }
        return result;
    }
}
