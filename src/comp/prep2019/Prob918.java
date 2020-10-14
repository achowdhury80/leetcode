package comp.prep2019;

public class Prob918 {
	public int maxSubarraySumCircular(int[] A) {
		int n;
		if ((n = A.length) < 2) return A[0];
        int minSum = A[0], maxSum = A[0], curMin = A[0], curMax = A[0], sum = A[0];
        for (int i = 1; i < A.length; i++) {
        	sum += A[i];
        	if (curMin > 0) curMin = 0;
        	if (curMax < 0) curMax = 0;
        	curMin += A[i];
        	curMax += A[i];
        	minSum = Math.min(minSum, curMin);
        	maxSum = Math.max(maxSum, curMax);
        }
        
        return Math.max(maxSum, sum - minSum == 0 ? Integer.MIN_VALUE 
        		: sum - minSum);
    }
}
