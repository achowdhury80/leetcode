package com.leet.algo;

public class Prob799 {
	public double champagneTower(int poured, int query_row, int query_glass) {
        double[] arr = new double[1];
        arr[0] = poured;
        double[] next = null;;
        for (int i = 1; i <= query_row; i++) {
        	next = new double[i + 1];
        	for (int j = 0; j < arr.length; j++) {
        		double q = (arr[j] - 1) / 2.0;
        		if (q > 0) {
        			next[j] += q;
        			next[j + 1] += q;
        		}
        	}
        	arr = next;
        }
        return Math.min(1, arr[query_glass]);
    }
}
