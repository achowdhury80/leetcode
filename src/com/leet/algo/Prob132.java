package com.leet.algo;

public class Prob132 {
	/**
	 * O(n^2) time and space
	 * cut[i] suggests number of cuts for first i - 1 elements
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        boolean[][] isPal = new boolean[n][n];
        int[] cut = new int[n + 1];
        //important
        // if isPal[0][i] then cut[i] should be 0. 
        // since cut[i] = cut[j] + 1 then cut[0] should be -1 
        cut[0] = -1;
        for (int i = 1; i <= n; i++) {
        	cut[i] = i - 1;
        	for (int j = 0; j < i; j++) {
        		if (arr[j] == arr[i - 1] && (j + 2  >= i || isPal[j + 1][i - 2])) {
        			isPal[j][i - 1] = true;
        			cut[i] = Math.min(cut[i], cut[j] + 1);
        		}
        	}
        }
        return cut[n];
    }
	
	public static void main(String[] args) {
		Prob132 prob = new Prob132();
		System.out.println(prob.minCut("aab"));
	}
}
