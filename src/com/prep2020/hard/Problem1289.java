package com.prep2020.hard;
import java.util.*;
public class Problem1289 {
	/**
	 * O(M*N)
	 * @param arr
	 * @return
	 */
	public int minFallingPathSum(int[][] arr) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        q.offer(new int[] {-1, 0});
        q.offer(new int[] {-2, 0});
        for (int[] r : arr) {
        	Queue<int[]> temp = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        	for (int i = 0; i < r.length; i++) {
        		int[] min = q.poll();
        		int[] newSum = new int[2];
        		if (i != min[0]) newSum = new int[] {i, r[i] + min[1]};
        		else newSum = new int[] {i, r[i] + q.peek()[1]};
        		q.offer(min);
        		temp.add(newSum);
        		if (temp.size() > 2) temp.poll();
        	}
        	q.clear();
        	q.addAll(temp);
        }
        return q.peek()[1];
    }
}
