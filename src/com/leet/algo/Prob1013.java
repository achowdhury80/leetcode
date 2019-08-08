package com.leet.algo;
public class Prob1013 {
	public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) sum += i;
        if (sum % 3 != 0) return false;
        int part1Idx = -1;
        int partSum = 0;
        for (int i = 0; i < A.length - 2; i++) {
        	partSum += A[i];
        	if (partSum == sum / 3) {
        		part1Idx = i;
        		break;
        	}
        }
        if (part1Idx == - 1) return false;
        partSum = 0;
        for (int i = A.length - 1; i > part1Idx + 1; i--) {
        	partSum += A[i];
        	if (partSum == sum / 3) {
        		return true;
        	}
        }
        return false;
    }
}
