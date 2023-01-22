package com.prep2020.easy;

public class Problem1624 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) arr[i] = -1;
        int start = 0;
        arr[s.charAt(0) - 'a'] = 0;
        int result = -1;
        for (int i = 1; i < s.length(); i++) {
        	int idx = s.charAt(i) - 'a';
        	if (arr[idx] > -1) {
        		result = Math.max(result, i - arr[idx] - 1);
        	} else arr[idx] = i;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1624 problem = new Problem1624();
		System.out.println(problem.maxLengthBetweenEqualCharacters("scayofdzca"));
	}
}
