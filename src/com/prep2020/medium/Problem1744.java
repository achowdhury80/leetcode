package com.prep2020.medium;

public class Problem1744 {
	public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        int n = candiesCount.length;
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
        	sum[i] = sum[i - 1] + candiesCount[i];
        }
        for (int i = 0; i < queries.length; i++) {
        	int type = queries[i][0];
        	long minToEat = (type == 0) ? 0 : sum[type - 1];
        	long maxToEat = sum[type] - 1;
        	long canEatMin = queries[i][1], canEatMax = 1l * queries[i][1] * queries[i][2];
        	if (canEatMin > maxToEat || canEatMax < minToEat) result[i] = false;
        	else result[i] = true;
        }
        return result;
    }
}
