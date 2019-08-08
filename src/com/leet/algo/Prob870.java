package com.leet.algo;

import java.util.Arrays;

public class Prob870 {
	/*
	 * O(nlogn)
	 * o(n) space
	 * create two new arrays in ascending order of value for A & B. Also, store the index.
	 * iterate from right to left for sorted B 
	 * 
	 */
	public int[] advantageCount(int[] A, int[] B) {
        int[][] first = new int[A.length][2];
        int[][] last = new int[B.length][2];
        for (int i = 0; i < A.length; i++) { 
        	first[i] = new int[] {A[i], i};
        	last[i] = new int[] {B[i], i};
        }
        Arrays.sort(first, (x, y) -> x[0] - y[0]);
        Arrays.sort(last, (x, y) -> x[0] - y[0]);
        int i = 0;
        int[] result = new int[A.length];
        int k = first.length - 1;
        for (int j = last.length - 1; j > -1; j--) {
        	if (last[j][0] < first[k][0]) {
        		result[last[j][1]] = first[k][0];
        		k--;
        	} else {
        		result[last[j][1]] = first[i][0];
        		i++;
        	}
        }
        return result;
    }
}
