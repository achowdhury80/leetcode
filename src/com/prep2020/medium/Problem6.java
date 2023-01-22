package com.prep2020.medium;

public class Problem6 {
	/**
	 * O(N)
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < arr.length; i++) arr[i] = new StringBuilder();
        int dir = 1, idx = 0;
        for (int i = 0; i < s.length(); i++) {
        	arr[idx].append(s.charAt(i));
        	if (idx == 0) dir = 1;
        	else if (idx == numRows - 1) dir = -1;
        	idx += dir;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : arr)
        	result.append(sb.toString());
        return result.toString();
    }
}
