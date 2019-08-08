package com.leet.algo;

public class Prob921 {
	public int minAddToMakeValid(String S) {
        char[] arr = S.toCharArray();
        int result = 0;
        int addLeft = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '(') result++;
        	else {
        		if (result < 1) {
        			addLeft++;
        		} else result--;
        	}
        }
        return addLeft + Math.abs(result);
    }
}
