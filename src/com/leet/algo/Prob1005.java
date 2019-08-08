package com.leet.algo;
import java.util.Arrays;

public class Prob1005 {
	public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
        	min = Math.min(min, Math.abs(A[i]));
        	if (A[i] < 0 && K > 0) {
        		sum -= A[i];
        		K--;
        	} else sum += A[i];
        }
        if (K % 2 == 1) sum -= 2 * min;
        return sum;
    }
}
