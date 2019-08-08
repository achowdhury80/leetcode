package com.leet.algo;

public class Prob861 {
	public int matrixScore(int[][] A) {
		int result = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i][0] == 0) toggle(A, i, true);
        	result += Math.pow(2, A[0].length - 1);
        }
        for (int i = 1; i < A[0].length; i++) {
        	int oneCount= 0; 
        	for (int j = 0; j < A.length; j++) {
        		if (A[j][i] == 1) oneCount++;
        	}
        	if (oneCount < (A.length + 1) / 2) {
        		oneCount = A.length - oneCount;
        		toggle(A, i, false);
        	}
        	result += oneCount * Math.pow(2, A[0].length - i - 1);
        }
        return result;
    }
	
	private void toggle(int[][] A, int idx, boolean row) {
		if (row) 
			for (int i = 0; i < A[0].length; i++) A[idx][i] ^= 1;
		else 
			for (int i = 0; i < A.length; i++) A[i][idx] ^= 1;
	}
	
	public static void main(String[] argw) {
		Prob861 prob = new Prob861();
		int[][] A = new int[][] {{0,0, 1, 1},{1,0,1,0}, {0,0,1,1}};
		System.out.println(prob.matrixScore(A));
	}
}
