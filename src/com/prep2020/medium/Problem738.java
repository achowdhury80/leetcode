package com.prep2020.medium;

public class Problem738 {
	public int monotoneIncreasingDigits(int n) {
		if (n < 10) return n;
        String s = "" + n;
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++) {
        	if (arr[i] < arr[i - 1]) {
        		for (int j = i; j < arr.length; j++) arr[j] = '9';
        		arr[i - 1] = (char)(arr[i - 1] - 1);
        		for (int j = i - 2; j > -1; j--) {
        			if (arr[j] <= arr[j + 1]) break;
        			arr[j + 1] = '9';
        			arr[j] = (char)(arr[j] - 1);
        		}
        		break;
        	}
        }
        int i = 0;
        while(arr[i] == '0') i++;
        int result = 0;
        while(i < arr.length) {
        	result = result * 10 + (arr[i] - '0');
        	i++;
        }
        return result;
    }
}
