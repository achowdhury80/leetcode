package com.prep2020.medium;
public class Problem678 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean checkValidString(String s) {
		char[] arr = s.toCharArray();
		return isLeftValid(arr) && isRightValid(arr);
    }
	
	private boolean isLeftValid(char[] arr) {
		int count = 0, star = 0;
		for (char c : arr) {
			if (c == '(') count++;
        	else if (c == '*') star++;
        	else {
        		if (count > 0) count--;
        		else if (star > 0) star--;
        		else return false;
        	}
		}
		return true;
	}
	private boolean isRightValid(char[] arr) {
		int count = 0, star = 0;
		for (int i = arr.length - 1; i > -1; i--) {
			char c = arr[i];
			if (c == ')') count++;
        	else if (c == '*') star++;
        	else {
        		if (count > 0) count--;
        		else if (star > 0) star--;
        		else return false;
        	}
		}
		return true;
	}
}
