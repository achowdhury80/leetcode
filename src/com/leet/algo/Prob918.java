package com.leet.algo;

public class Prob918 {
	/*
	 * O(n)
	 * either regular max of total minus min
	 * 
	 */
	public int maxSubarraySumCircular(int[] A) {
        int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;
        int total = 0, sum = 0;
        
        //next two loops can be combined together
        //computing max sum
        for (int i = 0; i < A.length; i++) {
        	total += A[i];
        	if (sum + A[i] > A[i]) sum += A[i];
        	else sum = A[i];
        	maxSum = Math.max(maxSum, sum);
        }
        sum = 0;
      //computing min sum
        for (int i = 0; i < A.length; i++) {
        	if (sum + A[i] < A[i]) sum += A[i];
        	else sum = A[i];
        	minSum = Math.min(minSum, sum);
        }
        //if total == minSum then cannot use total - minSum as it covers the whole array
        return total == minSum ? maxSum : Math.max(maxSum, total - minSum);
    }
	
	public static void main(String[] args) {
		Prob918 prob = new Prob918();
		//System.out.println(prob.maxSubarraySumCircular(new int[] {1, -2, 3, -2}));
		System.out.println(prob.maxSubarraySumCircular(new int[] {5, -3, 5}));
	}
}
