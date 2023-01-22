package com.prep2020.medium;

import java.util.*;

public class Problem1094 {
	/**
	 * O(NlogN)
	 * @param trips
	 * @param capacity
	 * @return
	 */
	public boolean carPooling(int[][] trips, int capacity) {
		List<int[]> list = new ArrayList<>();
		for (int[] trip: trips) {
			list.add(new int[] {trip[0], trip[1]});
			list.add(new int[] {-trip[0], trip[2]});
		}
        Collections.sort(list, (x, y) -> (x[1] == y[1] ? (x[0] - y[0]) : (x[1] - y[1])));
        int people = 0;
        for (int[] arr : list) {
        	people += arr[0];
        	if (people > capacity) return false;
        }
        return true;
    }
}
