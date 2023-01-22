package com.prep2020.medium;

import java.util.Arrays;

public class Problem1552 {
	/**
	 * nlogn + log(range).log(n)
	 * @param position
	 * @param m
	 * @return
	 */
	public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        if (m == 2) return position[n - 1] - position[0];
        int low = 1, high = position[n - 1] - position[0], result = 0;
        while (low <= high) {
        	int mid = low + (high - low) / 2;
        	if (possible(position, m, mid)) {
        		result = mid;
        		low = mid + 1;
        	}
        	else high = mid - 1;
        }
        return result;
    }

	private boolean possible(int[] position, int m, int mid) {
		int last = position[0], cur = 1;
		m--;
		while(cur < position.length && m > 0 && (cur = found(last + mid, position, cur)) > -1) {
			m--;
			last = position[cur];
			cur++;
		}
		return m == 0;
	}

	private int found(int distance, int[] position, int start) {
		int low = start, high = position.length - 1;
		int result = -1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if (position[mid] >= distance) {
				result = mid;
				high = mid - 1;
			} else low = mid + 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem1552 problem = new Problem1552();
		System.out.println(problem.maxDistance(new int[] {79,74,57,22}, 4));
	}
}
