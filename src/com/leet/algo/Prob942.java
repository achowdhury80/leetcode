package com.leet.algo;

public class Prob942 {
	public int[] diStringMatch(String S) {
		int n = S.length();
        int min = 0, max = n;
        int[] result = new int[n + 1];
        char[] arr = S.toCharArray();
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == 'I') result[idx++] = min++;
        	else result[idx++] = max--;
        }
        result[idx] = min;
        return result;
    }
}
