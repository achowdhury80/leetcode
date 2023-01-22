package com.prep2020.medium;

public class Problem1007 {
	public int minDominoRotations(int[] A, int[] B) {
		int[] aMax = findMostFrequentElemWithFrequency(A);
        if (aMax[1] == A.length) return 0;
        int[] bMax = findMostFrequentElemWithFrequency(B);
        if (bMax[1] == B.length) return 0;
        int aCountFilp = countFlip(aMax[0], A, B);
        int bCountFilp = countFlip(bMax[0], B, A);
        if (aCountFilp == - 1) return bCountFilp;
        if (bCountFilp == - 1) return aCountFilp;
        return Math.min(aCountFilp, bCountFilp);
    }
	
	private int[] findMostFrequentElemWithFrequency(int[] arr) {
		int count = 1;
        int maxFreqElem = arr[0];
        for (int i = 1; i < arr.length; i++) {
        	if (arr[i] == maxFreqElem) count++;
        	else {
        		count--;
        		if (count == 0) {
        			count++;
        			maxFreqElem = arr[i];
        		}
        	}
        }
        return new int[] {maxFreqElem, count};
	}
	
	private int countFlip(int aMaxFreqElem, int[] A, int[] B) {
		int flip1 = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] != aMaxFreqElem) {
        		if (B[i] == aMaxFreqElem) flip1++;
        		else {
        			return -1;
        		}
        	}
        }
        return flip1;
	}
}
