package com.prep2020.medium;

public class Problem186 {
	/**
	 * O(N)
	 * @param s
	 */
	public void reverseWords(char[] s) {
		int start = -1;
        for (int i = 0; i < s.length; i++) {
        	if (s[i] == ' ') {
        		reverse(s, start, i - 1);
        		start = -1;
        	} else {
        		if (start == -1) start = i;
        	}
        }
        if (start > -1) reverse(s, start, s.length - 1);
        reverse(s, 0, s.length - 1);
    }
	
	private void reverse(char[] arr, int start, int end) {
		while(start < end) {
			char c = arr[start];
			arr[start] = arr[end];
			arr[end] = c;
			start++;
			end--;
		}
	}
}
