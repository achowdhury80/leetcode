package com.prep2020.easy;

import java.util.*;

public class Problem1356 {
	/**
	 * O(Nlogn) time and O(N) space
	 * @param arr
	 * @return
	 */
	public int[] sortByBits(int[] arr) {
		Queue<Integer> q = new PriorityQueue<>((x, y) -> {
			int xCount = Integer.bitCount(x), yCount = Integer.bitCount(y);
			if (xCount == yCount) return x - y;
			return xCount - yCount;
		});
		for (int i : arr) q.offer(i);
		int[] result = new int[arr.length];
		int idx = 0;
		while(!q.isEmpty()) result[idx++] = q.poll();
        return result;
    }
}
