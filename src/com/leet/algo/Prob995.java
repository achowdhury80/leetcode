package com.leet.algo;

public class Prob995 {
	public int minKBitFlips(int[] A, int K) {
        int result = 0;
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] == 0) {
        		if (i + K > n) return -1;
        		for (int j = 0; j < K; j++) A[i + j] ^= 1;
        		result++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob995 prob = new Prob995();
		System.out.println(prob.minKBitFlips(new int[] {0,0,0,1,0,1,1,0}, 3));
	}
}
