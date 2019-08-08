package com.leet.algo;
import java.util.*;
public class Prob888 {
	public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0, bSum = 0;
        for (int i = 0; i < A.length; i++) aSum += A[i];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
        	bSum += B[i];
        	set.add(B[i]);
        }
        int diff = (aSum- bSum) / 2;
        for (int i = 0; i < A.length; i++) {
        	if (set.contains(A[i] - diff)) return new int[] {A[i], A[i] - diff};
        }
        return new int[2];
    }
}
