package comp.prep2019;
import java.util.*;
public class Prob1473 {
	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        return helper(houses, cost, m, n, target, 20, 0, new HashMap<>());
    }
	
	private int helper(int[] houses, int[][] cost, int m, int n, int target, 
			int lastColor, int next, Map<Integer, Integer> cache) {
		//last color(5), start(7), target(7)
		int key = (lastColor << 14) | (next << 7) | target;
		if (cache.containsKey(key)) return cache.get(key);
		if (next == m) {
			if (target > 0) cache.put(key, -1);
			else cache.put(key, 0);
		}
		else if (houses[next] > 0) {
			if (lastColor > 19 || lastColor != houses[next] - 1) {
				if (target == 0) {
					cache.put(key, -1);
				} else {
					int nextExp = helper(houses, cost, m, n, target - 1, 
							houses[next] - 1, next + 1, cache);
					cache.put(key, nextExp);
				}
			} else {
				int nextExp = helper(houses, cost, m, n, target, 
						houses[next] - 1, next + 1, cache);
				cache.put(key, nextExp);
			}
		} else { // not painted
			if (target == 0) {
				if (lastColor > 20) cache.put(key, -1);
				else {
					int nextExp = helper(houses, cost, m, n, target, 
							lastColor, next + 1, cache);
					cache.put(key, nextExp == - 1 ? -1 
							: (cost[next][lastColor] + nextExp));
				}
			} else {
				int result = Integer.MAX_VALUE;
				for (int i = 0; i < n; i++) {
					if (i == lastColor) {
						int nextExp = helper(houses, cost, m, n, target, 
								lastColor, next + 1, cache);
						if (nextExp > -1) {
							result = Math.min(result, cost[next][i] + nextExp);
						}
					} else {
						int nextExp = helper(houses, cost, m, n, target - 1, 
								i, next + 1, cache);
						if (nextExp > -1) {
							result = Math.min(result, cost[next][i] + nextExp);
						}
					}
				}
				cache.put(key, result == Integer.MAX_VALUE ? -1 : result);
			}
		}
	
		return cache.get(key);
	}
	
	public static void main(String[] args) {
		Prob1473 prob = new Prob1473();
		System.out.println(prob.minCost(new int[] {0, 0, 0, 0, 0}, 
				new int[][] {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));
	}
}
