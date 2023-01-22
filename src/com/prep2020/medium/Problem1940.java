package com.prep2020.medium;
import java.util.*;
public class Problem1940 {
	/**
	 * O(nlogK) and O(K)
	 * @param arrays
	 * @return
	 */
	public List<Integer> longestCommomSubsequence(int[][] arrays) {
		int n = arrays.length;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> arrays[x[0]][x[1]] - arrays[y[0]][y[1]]);
        for (int i = 0; i < arrays.length; i++) pq.offer(new int[] {i, 0});
        List<Integer> result = new ArrayList<>();
        while(pq.size() == n) {
        	List<int[]> nexts = new ArrayList<>();
        	int[] cur = pq.peek();
        	int val = arrays[cur[0]][cur[1]];
        	boolean flag = true;
        	for (int i = 0; i < n; i++) {
        		int[] peek = pq.peek();
        		if (arrays[peek[0]][peek[1]] == val) {
        			pq.poll();
        			if (peek[1] < arrays[peek[0]].length - 1) nexts.add(new int[] {peek[0], peek[1] + 1});
        		} else {
        			
        			flag = false;
        			break;
        		}
        	}
        	if (flag) result.add(val);
        	for (int[] next : nexts) pq.offer(next);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1940 problem = new Problem1940();
		System.out.println(problem.longestCommomSubsequence(new int[][] {{1, 3, 4}, {1, 4, 7, 9}}));
	}
}
