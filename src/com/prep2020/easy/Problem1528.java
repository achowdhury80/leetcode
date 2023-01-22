package com.prep2020.easy;

public class Problem1528 {
	/**
	 * O(N)
	 * @param s
	 * @param indices
	 * @return
	 */
	public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
        	arr[indices[i]] = s.charAt(i);
        }
        return new String(arr);
    }
}
