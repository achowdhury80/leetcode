package com.leet.algo;
import java.util.*;
public class Prob363 {
	 public int maxSumSubmatrix(int[][] matrix, int k) {
		 if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return 0;
	        }
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int max = Integer.MIN_VALUE;
	        int[][] sum = new int[m][n];
	        for (int i = 0; i < n; i++) {
	        	for (int j = 0; j < m; j++) {
	        		sum[j][i] += (i > 0 ? sum[j][i - 1] : 0) + matrix[j][i];
	        	}
	        }
	        for (int i = 0; i < n; i++) {
	        	for (int j = i; j < n; j++) {
	        		int curSum = 0;
	                TreeSet<Integer> sortedSet = new TreeSet<>();
	                sortedSet.add(0);
	        		for (int r = 0; r < m; r++) {
	        			curSum += sum[r][j] - (i > 0 ? sum[r][i - 1] : 0);
	        			Integer it = sortedSet.ceiling(curSum - k);
	        			if (it != null) {
	                        max = Math.max(max, curSum - it);
	                    }
	        			sortedSet.add(curSum);
	        		}
	        	}
	        }
	        return max;
	 }
	 
	 public static void main(String[] args) {
		 Prob363 prob = new Prob363();
		 System.out.println(prob.maxSumSubmatrix(new int[][] {{1,0,1},{0,-2,3}}, 2));
	 }
}
