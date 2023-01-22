package com.prep2020.medium;
import java.util.*;
public class Problem1057 {
	/**
	 * O(MN)logMN time and o(MN) space
	 * @param workers
	 * @param bikes
	 * @return
	 */
	public int[] assignBikes(int[][] workers, int[][] bikes) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> (x[2] == y[2] ? (x[0] == y[0] ? (x[1] - y[1]) : (x[0] - y[0])) : (x[2] - y[2])));
        for (int i = 0; i < workers.length; i++) {
        	for (int j = 0; j < bikes.length; j++) {
        		q.offer(new int[] {i, j, Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1])});
        	}
        }
        int[] result = new int[workers.length];
        boolean[] assigned = new boolean[workers.length], used = new boolean[bikes.length];
        int count = 0;
        while(!q.isEmpty() && count < workers.length) {
        	int[] arr = q.poll();
        	if (assigned[arr[0]] || used[arr[1]]) continue;
        	result[arr[0]] = arr[1];
        	assigned[arr[0]] = true;
        	used[arr[1]] = true;
        	count++;
        }
        return result;
    }
}
