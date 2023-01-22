package com.prep2020.hard;
import java.util.*;
public class Problem1298 {
	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int result = 0, n = status.length;
        boolean[] used = new boolean[n], available = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i : initialBoxes) {
        	available[i] = true;
        	if (status[i] == 1) q.offer(i);
        }
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	if (used[cur] || !available[cur] || status[cur] == 0) continue;
        	used[cur] = true;
        	result += candies[cur];
        	for (int box : containedBoxes[cur]) {
        		available[box] = true;
        		if (status[box] == 1)  q.offer(box);
        	}
        	for (int key : keys[cur]) {
        		status[key] = 1;
        		if (available[key]) q.offer(key);
        	}
        }
        return result;
    }
}
