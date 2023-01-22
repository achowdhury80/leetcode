package com.prep2020.medium.more2000;

public class Problem2086 {
	public int minimumBuckets(String street) {
        int result = 0;
        char[] arr = street.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == 'H') {
        		if ((i == 0 || arr[i - 1] == 'H' || arr[i - 1] == 'h') 
        			&& (i == arr.length - 1 || arr[i + 1] == 'H' || arr[i + 1] == 'h')) return -1;
        	} else if (arr[i] == '.') {
        		if (i > 0 && i < arr.length - 1 && arr[i - 1] == 'H' && arr[i + 1] == 'H') {
        			result++;
        			arr[i - 1] = 'h';
        			arr[i + 1] = 'h';
        		}
        	}
        }
        for (int i = 0; i <arr.length; i++) if (arr[i] == 'H') result++;
        return result;
    }
}
