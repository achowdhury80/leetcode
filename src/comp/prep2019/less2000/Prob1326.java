package comp.prep2019.less2000;

import java.util.*;

public class Prob1326 {
	public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1]; // dp[i] is the max distance it can reach 
        //using oene tap
        Arrays.fill(dp, -1);
        for (int i = 0; i <= n; i++) {
        	if (ranges[i] == 0) continue;
        	int left = Math.max(0, i - ranges[i]), 
        			right = Math.min(n, i + ranges[i]);
        	for (int j = left; j <= right; j++) {
        		dp[j] = Math.max(dp[j], right);
        	}
        }
        int result = 0, pos = 0;
        while(pos < n) {
        	if (dp[pos] == -1) return -1;
        	int right = dp[pos];
        	if (pos == right) return -1;
        	pos = right;
        	result++;
        }
        return result;
    }
	public int minTaps1(int n, int[] ranges) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
        	if (ranges[i] == 0) continue;
        	list.add(new int[] {Math.max(0, i - ranges[i]), 
        			Math.min(n, i + ranges[i])});
        }
        Collections.sort(list, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        if (list.size() == 0 || list.get(0)[0] > 0) return -1;
        int[] cur = list.get(0);
        int result = 1, max = cur[1], soFar = cur[1];
        if (soFar >= n) return result;
        for (int i = 1; i < list.size(); i++) {
        	int[] next = list.get(i);
        	if (next[1] <= soFar) continue;
        	else if (next[0] <= soFar) {
        		max = Math.max(max, next[1]);
        	} else if (next[0] > soFar) {
        		if (max < next[0]) return -1;
        		result++;
        		soFar = max;
        		if (soFar >= n) return result;
        		i--;
        	}
        }
        return max == n ? result + 1 : -1;
    }
	
	public static void main(String[] args) {
		Prob1326 prob = new Prob1326();
		//System.out.println(prob.minTaps(5, new int[] {3, 4, 1, 1, 0, 0}));
		System.out.println(prob.minTaps(7, new int[] {1, 2, 1, 0, 2, 1, 0, 1}));
	}
}
