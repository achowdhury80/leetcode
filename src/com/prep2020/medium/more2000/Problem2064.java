package com.prep2020.medium.more2000;

public class Problem2064 {
	/**
	 * O(nlogn)
	 * @param n
	 * @param quantities
	 * @return
	 */
	public int minimizedMaximum(int n, int[] quantities) {
        int max = Integer.MIN_VALUE;
        for (int q : quantities) max = Math.max(max, q);
        int low = 1, high = max - 1;
        int result = max;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	if (possible(n, quantities, mid)) {
        		result = mid;
        		high = mid - 1;
        	} else low = mid + 1;
        }
        return result;
    }

	private boolean possible(int n, int[] quantities, int q) {
		int cur = quantities[0];
		int idx = 0;
		while(cur > 0 && n > 0) {
			n--;
			if (cur <= q) {
				idx++;
				if (idx == quantities.length) return true;
				cur = quantities[idx];
			} else cur -= q;
		}
		return false;
	}
}
