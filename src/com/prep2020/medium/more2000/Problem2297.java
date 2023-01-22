package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2297 {
	/**
	 * https://leetcode.com/problems/jump-game-ix/discuss/2133460/Java-O(n)-solution-monotonic-stack-%2B-dp-general-thinking-process-for-solving-Jump-Game-problems
	 * @param nums
	 * @param costs
	 * @return
	 */
	public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        List<Integer>[] nexts = new List[n];
        for (int i = 0; i < n; i++) nexts[i] = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
        	while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        		nexts[stack.pop()].add(i);
        	}
        	stack.push(i);
        }
        stack.clear();
        stack.push(0);
        for (int i = 1; i < n; i++) {
        	while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
        		nexts[stack.pop()].add(i);
        	}
        	stack.push(i);
        }
        long[] dist = new long[n];
        for (int i = 1; i < n; i++) dist[i] = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
        	for (int next : nexts[i]) {
        		dist[next] = Math.min(dist[next], dist[i] + costs[next]);
        	}
        }
        return dist[n - 1];
    }
}
