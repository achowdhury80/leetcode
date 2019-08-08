package com.leet.algo;

public class Prob845 {
	public int longestMountain(int[] A) {
        int min = -1;
        boolean ascending = true;
        int result = 0;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] == A[i - 1]) {
        		if (!ascending) {
        			result = Math.max(result, i - min);
        		}
        		min = -1;
        		ascending = true;
        		continue;
        	}
        	if (min == -1 && A[i] < A[i - 1]) continue;
        	if (min == -1) {
        		min = i - 1;
        		ascending = true;
        		continue;
        	}
        	if(A[i] < A[i - 1]) {
        		ascending = false;
        	} else {
        		if (!ascending) {
        			result = Math.max(result, i - min);
        			min = i - 1;
            		ascending = true;
        		}
        	}
        	
        }
        if (min != -1 && !ascending) 
    		result = Math.max(result, A.length - min);
    	return result;
    }
	
	public static void main(String[] args) {
		Prob845 prob = new Prob845();
		System.out.println(prob.longestMountain(new int[] {875,884,239,731,723,685}));
	}
}
