package com.leet.algo;

import java.util.Arrays;

public class Prob805 {
	public boolean splitArraySameAverage(int[] A) {
        double sum = 0;
        for (int a : A) sum += a;
        double avg = sum / A.length;
        Arrays.sort(A);
        return func(A, avg, 0, 0, 0);
    }
	
	private boolean func(int[] A, double avg, int start, double sum, int count) {
		if (count > A.length / 2) return false;
		if (count > 0 && count < A.length && sum / count == avg) return true;
		for (int i = start; i < A.length; i++) {
			if (i > start && A[i] == A[i - 1]) continue;
			if (func(A, avg, i + 1, sum + A[i], count + 1)) return true;
		}
		return false;
	}
}
