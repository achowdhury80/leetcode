package com.prep2020.medium.more2000;

public class Problem2105 {
	/**
	 * O(N)
	 * @param plants
	 * @param capacityA
	 * @param capacityB
	 * @return
	 */
	public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0, j = plants.length - 1;
        int result = 0;
        int curA = capacityA, curB = capacityB;
        while(i < j) {
        	while (plants[i] > curA) {
        		if (curA < capacityA) {
        			curA = capacityA;
            		result++;
        		}
        		int min = Math.min(plants[i], curA);
        		plants[i] -= min;
        		curA -= min;
        	}
        	if (plants[i] > 0) curA -= plants[i];
        	i++;
        	while (plants[j] > curB) {
        		if (curB < capacityB) {
        			curB = capacityB;
            		result++;
        		}
        		int min = Math.min(plants[j], curB);
        		plants[j] -= min;
        		curB -= min;
        	}
        	if (plants[j] > 0) curB -= plants[j];
        	j--;
        }
        if (i == j) {
        	int[] cur = new int[] {curA, capacityA};
        	if (curB > curA) cur = new int[] {curB, capacityB};
        	while (plants[i] > cur[0]) {
        		if (cur[0] < cur[1]) {
        			cur[0] = cur[1];
            		result++;
        		}
        		int min = Math.min(plants[i], cur[0]);
        		plants[i] -= min;
        		cur[0] -= min;
        	}
        }
        return result;
    }
}
