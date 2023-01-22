package com.prep2020.easy;
import java.util.*;
public class Problem830 {
	/**
	 * O(NlogN) time and O(N) space
	 * @param s
	 * @return
	 */
	public List<List<Integer>> largeGroupPositions(String s) {
		Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
		int start = 0;
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c != s.charAt(i - 1)) {
        		if (i - start >= 3) q.offer(new int[] {start, i - 1});
        		start = i;
        	}
        }
        if (s.length() - start >= 3) q.offer(new int[] {start, s.length() - 1});
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()) {
        	int[] intv = q.poll();
        	result.add(Arrays.asList(intv[0], intv[1]));
        }
        return result;
    }
}
