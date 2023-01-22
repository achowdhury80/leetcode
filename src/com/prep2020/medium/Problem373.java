package com.prep2020.medium;
import java.util.*;
public class Problem373 {
	/**
	 * O(m * n logK)
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums1.length < 1 || nums2.length < 1) return result;
        Queue<int[]> q = new PriorityQueue<>((x, y) -> nums1[x[0]] + nums2[x[1]] - nums1[y[0]] - nums2[y[1]]);
        q.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        visited[0][0] = true;
        while(!q.isEmpty() && k > 0) {
        	int[] cur = q.poll();
        	result.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
        	k--;
        	if (cur[0] < nums1.length - 1 && !visited[cur[0] + 1][cur[1]]) {
        		q.offer(new int[] {cur[0] + 1, cur[1]});
        		visited[cur[0] + 1][cur[1]] = true;
        	}
        	if (cur[1] < nums2.length - 1 && !visited[cur[0]][cur[1] + 1]) {
        		q.offer(new int[] {cur[0], cur[1] + 1});
        		visited[cur[0]][cur[1] + 1] = true;
        	}
        }
        return result;
    }
}
