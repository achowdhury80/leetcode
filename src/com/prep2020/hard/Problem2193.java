package com.prep2020.hard;

public class Problem2193 {
	public int minMovesToMakePalindrome(String s) {
        int start = 0, end = s.length() - 1;
        int result = 0;
        char[] arr = s.toCharArray();
        while(start < end) {
        	if (arr[start] == arr[end]) {
        		start++;
        		end--;
        	} else {
        		int i = end;
        		while(i > start && arr[i] != arr[start]) i--;
        		if (i == start) {
        			swap(arr, start, start + 1);
        			result++;
        		} else {
        			while(i < end) {
        				swap(arr, i, i + 1);
        				i++;
        				result++;
        			}
        		}
        	}
        }
        return result;
    }
	
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
