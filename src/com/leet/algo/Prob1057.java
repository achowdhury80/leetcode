package com.leet.algo;
import java.util.*;
public class Prob1057 {
	public int[] assignBikes(int[][] workers, int[][] bikes) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) ->  (x[0] == y[0]) ? (x[1] == y[1] ? 
				(x[2] - y[2]) : (x[1] - y[1])) : (x[0] - y[0]));
		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
				pq.offer(new int[] {dist, i, j});
			}
		}
		int[] ans = new int[workers.length];
		for (int i = 0; i < ans.length; i++) ans[i] = -1;
		int count = 0;
		Set<Integer> captured = new HashSet<>();
		while(count < ans.length) {
			int[] data = pq.poll();
			if (ans[data[1]] != -1 || captured.contains(data[2])) continue;
			ans[data[1]] = data[2];
			captured.add(data[2]);
			count++;
		}
		return ans;
    }
}
