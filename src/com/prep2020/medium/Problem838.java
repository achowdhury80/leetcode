package com.prep2020.medium;

public class Problem838 {
	/**
	 * O(N)
	 * @param dominoes
	 * @return
	 */
	public String pushDominoes(String dominoes) {
        int lastRIndex = -1;
        char[] arr = dominoes.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == 'L') {
        		if (lastRIndex == -1) {
        			for (int j = i - 1; j > -1; j--) {
        				if (arr[j] != '.') break;
        				arr[j] = 'L';
        			}
        		} else {
        			int j = lastRIndex + 1, k = i - 1;
        			while(j < k) {
        				arr[j++] = 'R';
        				arr[k--] = 'L';
        			}
        			lastRIndex = -1;
        		}
        	} else if (arr[i] == 'R') {
        		if (lastRIndex != -1) {
        			for (int j = lastRIndex + 1; j < i; j++) arr[j] = 'R';
        		}
        		lastRIndex = i;
        	}
        }
        if (lastRIndex > -1) for (int j = lastRIndex + 1; j < arr.length; j++) arr[j] = 'R';
        return new String(arr);
    }
}
