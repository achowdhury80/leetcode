package com.prep2020.hard;

public class Problem1687 {
	public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
		int n = boxes.length;
		int[] dp = new int[n];
		dp[n - 1] = 2;
		for (int i = n - 2; i > -1; i--) {
			int curCount = 0, curWeight = 0, curTrip = 0, curPort = 0;
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; i + j < n; j++) {
				if (curCount + 1 > maxBoxes || curWeight + boxes[i + j][1] > maxWeight) break;
				curCount++;
        		curWeight += boxes[i + j][1];
        		if (curPort != boxes[i + j][0]) {
        			curTrip++;
        			curPort = boxes[i + j][0];
        		}
				dp[i] = Math.min(dp[i], curTrip + 1 + ((i + j + 1) < n ? dp[i + j + 1] : 0));
			}
		}
        return dp[0];
    }
	
	public static void main(String[] args) {
		Problem1687 problem = new Problem1687();
		System.out.println(problem.boxDelivering(new int[][] {{2,4},{2,5},{3,1},{3,2},{3,7},{3,1},{4,4},{1,3},{5,2}}, 5, 5, 7));
	}
}
