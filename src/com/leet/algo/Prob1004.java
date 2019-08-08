package com.leet.algo;

public class Prob1004 {
	public int longestOnes(int[] A, int K) {
		int result = 0, zeroCount = 0;
        for (int start = 0, end = 0; end < A.length; end++) {
        	if (A[end] == 0) zeroCount++;
        	while(zeroCount > K) {
        		if (A[start] == 0) {
        			zeroCount--;
        		}
        		start++;
        	}
        	result = Math.max(result, end - start + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1004 prob = new Prob1004();
		System.out.println(prob.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
	}
}
