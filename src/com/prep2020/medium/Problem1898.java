package com.prep2020.medium;

public class Problem1898 {
	/**
	 * O(nlogn)
	 * @param s
	 * @param p
	 * @param removable
	 * @return
	 */
	public int maximumRemovals(String s, String p, int[] removable) {
        int result = 0;
        int low = 1, high = removable.length;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	if (isPossible(s, p, removable, mid)) {
        		result = mid;
        		low = mid + 1;
        	} else high = mid - 1;
        }
        return result;
    }

	private boolean isPossible(String s, String p, int[] removable, int mid) {
		boolean[] arr = new boolean[s.length()];
		for (int i = 0; i < mid; i++) arr[removable[i]] = true;
		int i = 0, j = 0;
		while(i < p.length() && j < s.length()) {
			if (arr[j] || s.charAt(j) != p.charAt(i)) {
				j++;
				continue;
			} else {
				i++;
				j++;
			}
		}
		return i == p.length();
	}
	
	public static void main(String[] args) {
		Problem1898 problem = new Problem1898();
		System.out.println(problem.maximumRemovals("abcacb", "ab", new int[] {3, 1, 0}));
	}
}
