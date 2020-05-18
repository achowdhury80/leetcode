package comp.prep2019;

public class Prob918 {
	public int maxSubarraySumCircular(int[] A) {
		if (A.length < 2) return A[0];
        int maxSum = A[0], minSum = A[0], sum = A[0], curMax = A[0], curMin = A[0];
        for (int i = 1; i < A.length; i++) {
        	int a = A[i];
        	sum += a;
        	if (curMin > 0) curMin = 0;
        	if (curMax < 0) curMax = 0;
        	curMin += a;
        	curMax += a;
        	minSum = Math.min(minSum, curMin);
        	maxSum = Math.max(maxSum, curMax);
        }
        return Math.max(maxSum, sum - minSum == 0 ? Integer.MIN_VALUE : sum - minSum);
    }
}
