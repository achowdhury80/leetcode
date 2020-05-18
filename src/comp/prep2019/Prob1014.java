package comp.prep2019;

public class Prob1014 {
	public int maxScoreSightseeingPair(int[] A) {
		int i = 0;
        int max = A[i] + i;
        for (int j = 1; j < A.length; j++) {
        	int cur = A[i] + i + A[j] - j;
        	max = Math.max(max, cur);
        	//if samller or equal then its better to take jth element as ith, and do the calculation
        	if (A[i] + i <= A[j] + j) {
        		i = j;
        	}
        }
        return max;
    }
}
