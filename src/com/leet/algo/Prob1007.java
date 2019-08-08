package com.leet.algo;

public class Prob1007 {
	public int minDominoRotations(int[] A, int[] B) {
        int aMax = A[0], aCount = 1, bMax = B[0], bCount = 1;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] == aMax) aCount++;
        	else {
        		aCount--;
        		if (aCount == 0) {
        			aMax = A[i];
        			aCount = 1;
        		}
        	}
        	if (B[i] == bMax) bCount++;
        	else {
        		bCount--;
        		if (bCount == 0) {
        			bMax = B[i];
        			bCount = 1;
        		}
        	}
        }
        if(aCount == A.length || bCount == B.length) return 0;
        aCount = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] != aMax) {
        		if (B[i] == aMax) aCount++;
        		else {
        			aCount = Integer.MAX_VALUE;
        			break;
        		}
        	}
        }
        bCount = 0;
        for (int i = 0; i < A.length; i++) {
        	if (B[i] != bMax) {
        		if (A[i] == bMax) bCount++;
        		else {
        			bCount = Integer.MAX_VALUE;
        			break;
        		}
        	}
        }
        if (aCount == Integer.MAX_VALUE && bCount == Integer.MAX_VALUE) return -1;
        return Math.min(aCount, bCount);
    }
	
	public static void main(String[] args) {
		Prob1007 prob = new Prob1007();
		System.out.println(prob.minDominoRotations(new int[] {2,1,2,4,2,2},
				new int[] {5,2,6,2,3,2}));
	}
}
