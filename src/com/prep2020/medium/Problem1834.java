package com.prep2020.medium;

import java.util.*;

public class Problem1834 {
	public int[] getOrder(int[][] tasks) {
		int n = tasks.length;
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) arr[i] = i;
        Arrays.sort(arr, (x, y) -> tasks[x][0] == tasks[y][0] ? (tasks[x][1] - tasks[y][1]) 
        		: (tasks[x][0] - tasks[y][0]));
        Queue<Integer> q = new PriorityQueue<>((x, y) -> tasks[arr[x]][1] == tasks[arr[y]][1] ? (arr[x] - arr[y]) 
        		: (tasks[arr[x]][1] - tasks[arr[y]][1]));
        int lastEnqued = -1, curTime = 0, idx = 0;
        int[] result = new int[n];
        while(!q.isEmpty() || lastEnqued < n -1) {
        	if (q.isEmpty()) {
        		q.offer(++lastEnqued);
        		curTime = Math.max(curTime, tasks[arr[lastEnqued]][0]);
        	}
        	while(lastEnqued < n -1 && tasks[arr[lastEnqued + 1]][0] <= curTime) {
        		q.offer(++lastEnqued);
        	}
        	int taskId = arr[q.poll()];
        	result[idx++] = taskId;
        	curTime += tasks[taskId][1];
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1834 problem = new Problem1834();
		//System.out.println(problem.getOrder(new int[][] {{1,2},{2,4},{3,2},{4,1}}));
		System.out.println(problem.getOrder(new int[][] {{7, 10},{7, 12},{7, 5},{7, 4},{7, 2}}));
	}
}
