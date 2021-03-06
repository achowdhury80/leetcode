package com.leet.algo;

import java.util.Arrays;

public class Prob949 {
	public String largestTimeFromDigits(int[] A) {
		Arrays.sort(A);
		for (int i = 3; i > -1; i--) {
			for (int j = 3; j > -1; j--) {
				if (i == j) continue;
				for (int k = 3; k > -1; k--) {
					if (i == k || j == k) continue;
					int l = (6 - i - j - k);
					if (isValid(A, i, j, k, l)) return "" + A[i] + A[j] + ":" + A[k] + A[l];
				}
			}
		}
		return "";
    }
	
	private boolean isValid(int[] A, int i, int j, int k, int l) {
		int hr = Integer.valueOf(A[i] + "" + A[j]);
		if (hr > 23 || hr < 0) return false;
		int min = Integer.valueOf(A[k] + "" + A[l]);
		if (min > 59 || min < 0) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Prob949 prob = new Prob949();
    	System.out.println(prob.largestTimeFromDigits(new int[] {1,2,3,4}));
    	System.out.println(prob.largestTimeFromDigits(new int[] {5,5,5,5}));
    }
}
