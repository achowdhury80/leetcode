package comp.prep2019;
import java.util.*;
public class Prob313 {
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
		Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
		for (int p : primes) q.offer(new int[] {p, p, 1});
		for (int i = 2; i <= n; i++) {
			int[] cur = q.poll();
			while(!q.isEmpty() && q.peek()[0] == cur[0]) {
				int[] arr = q.poll();
				arr[2]++;
				arr[0] = arr[1] * dp[arr[2]];
				q.offer(arr);
			}
			dp[i] = cur[0];
			cur[2]++;
			cur[0] = cur[1] * dp[cur[2]];
			q.offer(cur);
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Prob313 prob = new Prob313();
		System.out.println(prob.nthSuperUglyNumber(12, new int[] {2, 7, 13, 19}));
	}
}
