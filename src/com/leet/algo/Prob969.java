package com.leet.algo;
import java.util.*;
public class Prob969 {
	public List<Integer> pancakeSort(int[] A) {
        int[] pos = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
        	pos[A[i]] = i;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = A.length; i > 1; i--) {
        	if( pos[i] + 1 != i) {
        		if (pos[i] != 0) {
	        		result.add(pos[i] + 1);
	        		pancakeFlip(A, pos[i], pos);
        		}
        		result.add(i);
        		pancakeFlip(A, i - 1, pos);
        	}
        }
        return result;
    }
	
	private void pancakeFlip(int[] A, int k, int[] pos) {
		for (int i = 0; i < (k + 1) / 2; i++) {
			int temp = A[i];
			A[i] = A[k - i];
			A[k - i] = temp;
			pos[A[i]] = i;
			pos[A[k - i]] = k - i;
		}
	}
	
	public static void main(String[] args) {
		Prob969 prob = new Prob969();
		System.out.println(prob.pancakeSort(new int[] {3, 2, 4, 1}));
	}
}
