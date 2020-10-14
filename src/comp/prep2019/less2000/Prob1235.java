package comp.prep2019.less2000;

import java.util.*;

public class Prob1235 {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = profit.length;
        Integer[] arr = new Integer[n];
        for (int i = 0 ; i < n; i++) arr[i] = i;
        //sort the array on end time, start time, profit
        Arrays.sort(arr,
        		(x, y) -> endTime[x] == endTime[y] ? 
        				(startTime[x] == startTime[y] ? 
                				profit[y] - profit[x] 
                						: startTime[x] - startTime[y])
        				: endTime[x] - endTime[y]);
        // dp[i] max profit profit for first 0 to i -1th term
        int[] dp = new int[n];
        //maintains a map of end time and dp index (not array index)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dp[0] = profit[arr[0]];
        map.put(endTime[arr[0]], 0);
        for (int i = 1; i < n; i++) {
        	int idx = arr[i];
        	dp[i] = dp[i - 1];
        	Map.Entry<Integer, Integer> floorEntry = map.floorEntry(startTime[idx]);
        	int curProfit = profit[idx];
        	if (floorEntry != null) curProfit += dp[floorEntry.getValue()];
        	dp[i] = Math.max(dp[i], curProfit);
        	map.put(endTime[idx], i);
        }
        return dp[n - 1];
    }
	
	public static void main(String[] args) {
		Prob1235 prob = new Prob1235();
		System.out.println(prob.jobScheduling(new int[] {1, 2, 3, 3}, 
				new int[] {3, 4, 5, 6}, new int[] {50, 10, 40, 70}));
		System.out.println(prob.jobScheduling(new int[] {1, 2, 3, 4, 6}, 
				new int[] {3, 5, 10, 6, 9}, new int[] {20, 20, 100, 70, 60}));
	}
}
