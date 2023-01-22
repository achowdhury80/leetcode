package com.prep2020.medium;

public class Problem134 {
	/**
	 * O(N)
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int minIndex = -1, minDelta = 0, delta = 0, n = cost.length;
        for (int i = 0; i < n; i++) {
        	delta += gas[i] - cost[i];
        	if (minIndex == -1 || minDelta >= delta) {
        		minIndex = i;
        		minDelta = delta;
        	}
        }
        return delta < 0 ? -1 : (minIndex + 1) % n;
    }
	
	public static void main(String[] args) {
		Problem134 problem = new Problem134();
		System.out.println(problem.canCompleteCircuit(
				new int[] {1, 2, 3, 4, 5},  new int[] {3, 4, 5, 1, 2}));
	}
}
