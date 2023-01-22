package com.prep2020.medium;
import java.util.*;
public class Problem313 {
	/**
	 * O(nlogk)
	 * @param n
	 * @param primes
	 * @return
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n < 2) return n;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
		for (int p : primes) pq.offer(new int[] {p, p, 1});
		for (int i = 2; i < n + 1; i++) {
			int[] cur = pq.poll();
			while(!pq.isEmpty() && pq.peek()[0] == cur[0]) {
				int[] arr = pq.poll();
				arr[2]++;
				arr[0] = arr[1] * dp[arr[2]];
				pq.offer(arr);
			}
			dp[i] = cur[0];
			cur[2]++;
			cur[0] = cur[1] * dp[cur[2]];
			pq.offer(cur);
		}
		return dp[n];
	}
}
