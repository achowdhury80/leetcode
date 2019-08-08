package com.leet.algo;

public class Prob917 {
	public String reverseOnlyLetters(String S) {
        if (S == null) return S;
        char[] arr = S.toCharArray();
        int start = 0, end = arr.length - 1;
        while(start < end) {
        	if (!Character.isLetter(arr[start])) {
        		start++;
        		continue;
        	}
        	if (!Character.isLetter(arr[end])) {
        		end--;
        		continue;
        	}
        	swap(arr, start, end);
        	start++;
        	end--;
        }
        return new String(arr);
    }
	
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
