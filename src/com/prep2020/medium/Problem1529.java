package com.prep2020.medium;

public class Problem1529 {
	/**
	 * O(N)
	 * @param target
	 * @return
	 */
	public int minFlips(String target) {
        char[] arr = new char[] {'0', '1'};
        int result = 0, cur = 0;
        for (int i = 0; i < target.length(); i++) {
        	if (target.charAt(i) != arr[cur]) {
        		result++;
        		cur = (cur + 1) % 2;
        	}
        }
        return result;
    }
}
