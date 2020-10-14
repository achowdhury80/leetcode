package comp.prep2019.less2000;

import java.util.Arrays;

public class Prob1005 {
	/**
	 * O(NlogN) because of sort
	 * try to make all negative to positive
	 * find the min positive element
	 * if k is still more than 0 and odd
	 * consider the min to be negative
	 * @param A
	 * @param K
	 * @return
	 */
	public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] < 0 && K > 0) {
        		sum -= A[i];
        		min = Math.min(min, -A[i]);
        		K--;
        	} else {
        		sum += A[i];
        		min = Math.min(min, A[i]);
        	}
        }
        if (K > 0 && K % 2 == 1) sum -= 2 * min;
        return sum;
    }
}
