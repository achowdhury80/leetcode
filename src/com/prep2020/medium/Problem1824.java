package com.prep2020.medium;
import java.util.*;
public class Problem1824 {
	/**
	 * O(N)
	 * @param obstacles
	 * @return
	 */
	/*public int minSideJumps1(int[] obstacles) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(obstacles, 0, 1, map);
    }
	
	private int helper(int[] obstacles, int cur, int lane, Map<Integer, Integer> map) {
		if (cur == obstacles.length - 1) return 0;
		int key = (cur << 2) | lane;
		if (map.containsKey(key)) return map.get(key);
		if (obstacles[cur + 1] == 0 || obstacles[cur + 1] != lane + 1) {
			map.put(key, helper(obstacles, cur + 1, lane, map));
			return map.get(key);
		}
		map.put(key, Math.min(
				((obstacles[cur] - 1 == (lane + 1) % 3) ? 2 : 1) + helper(obstacles, cur + 1, (lane + 1) % 3, map), 
				((obstacles[cur] - 1 == (lane + 2) % 3) ? 2 : 1) + helper(obstacles, cur + 1, (lane + 2) % 3, map)));
		return map.get(key);
	}*/
	
	public int minSideJumps(int[] obstacles) {
		int n = obstacles.length;
		int[] dp = new int[3];
		for (int i = n - 2; i > -1; i--) {
			int[] temp = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, 
					Integer.MAX_VALUE};
			for (int j = 0; j < 3; j++) {
				if (obstacles[i] == j + 1) {
					continue;
				}
				for (int k = 0; k < 3; k++) {
					if (dp[k] == Integer.MAX_VALUE || obstacles[i] == k + 1) continue;
					temp[j] = Math.min(temp[j], (j == k ? 0 : 1) + dp[k]);
				}
			}
			dp = temp;
		}
        return dp[1];
    }
	
	public static void main(String[] args) {
		Problem1824 problem = new Problem1824();
		System.out.println(problem.minSideJumps(new int[] {0,1,2,3,0}));
	}
}
