package com.prep2020.medium;
import java.util.*;
public class Problem1376 {
	/**
	 * O(N) time and space
	 * @param n
	 * @param headID
	 * @param manager
	 * @param informTime
	 * @return
	 */
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
        	list.add(i);
        	map.put(manager[i], list);
        }
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {headID, 0});
        int result = 0;
        while(!stack.isEmpty()) {
        	int[] cur = stack.pop();
        	for (int e : map.getOrDefault(cur[0], new ArrayList<>())) {
        		int[] next = new int[] {e, cur[1] + informTime[cur[0]]};
        		result = Math.max(result, next[1]);
        		stack.push(next);
        	}
        }
        return result;
    }
}
