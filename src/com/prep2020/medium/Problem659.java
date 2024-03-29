package com.prep2020.medium;
import java.util.*;
public class Problem659 {
	public boolean isPossible(int[] nums) {
		if (nums.length < 3) return false;
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        for (int i : nums) {
        	int[] arr;
        	while (!q.isEmpty() && (arr = q.peek())[0] < i - 1) {
        		if (arr[0] - arr[1] < 2) return false;
        		q.poll();
        	}
        	if (q.isEmpty() || q.peek()[0] == i) {
        		q.offer(new int[] {i, i});
        		continue;
        	}
        	arr = q.poll();
        	arr[0] = i;
        	q.offer(arr);
        }
        while(!q.isEmpty()) {
        	int[] arr = q.poll();
        	if (arr[0] - arr[1] < 2) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem659 problem = new Problem659();
		//System.out.println(problem.isPossible(new int[] {1,2,3,4,4,5}));
		System.out.println(problem.isPossible(new int[] {1,2,3,3,4, 4, 5, 5}));
	}
}
