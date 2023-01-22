package com.prep2020.medium;

public class Problem1208 {
	/**
	 * O(nlogn)
	 * @param s
	 * @param t
	 * @param maxCost
	 * @return
	 */
	public int equalSubstring(String s, String t, int maxCost) {
        int low = 1, high = s.length();
        int result = 0;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	boolean isInRange = IsWithInMaxCost(s, t, maxCost, mid);
        	if (isInRange) {
        		result = mid;
        		low = mid + 1;
        	} else high = mid - 1;
        }
        return result;
    }

	private boolean IsWithInMaxCost(String s, String t, int maxCost, int len) {
		int cur = 0;
		for (int i = 0; i < len; i++) {
			cur += Math.abs(s.charAt(i) - t.charAt(i));
		}
		if (cur <= maxCost) return true;
		int i = len;
		while(i < s.length()) {
			cur -= Math.abs(s.charAt(i - len) - t.charAt(i - len));
			cur += Math.abs(s.charAt(i) - t.charAt(i));
			if (cur <= maxCost) return true;
			i++;
		}
		return false;
	}
}
