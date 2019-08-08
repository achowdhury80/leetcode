package com.leet.algo;

public class Prob821 {
	public int[] shortestToChar(String S, char C) {
		int[] result = new int[S.length()];
		int leftIndex = -10001;
		char[] arr = S.toCharArray();
		for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == C) {
        		result[i] = 0;
        		leftIndex = i;
        	}
        	else result[i] = i - leftIndex;
        	
        }
		int rightIndex = 10001;
		for (int i = arr.length - 1; i > -1; i--) {
        	if (arr[i] == C) {
        		result[i] = 0;
        		rightIndex = i;
        	}
        	else result[i] = Math.min(result[i], rightIndex - i);
        	
        }
        return result;
    }
}
