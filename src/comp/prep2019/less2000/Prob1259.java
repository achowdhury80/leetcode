package comp.prep2019.less2000;
public class Prob1259 {
	/**
	 * https://leetcode.com/problems/handshakes-that-dont-cross/discuss/430539/JavaC%2B%2BPython-DP-and-O(N)
	 * @param num_people
	 * @return
	 */
	public int numberOfWays(int num_people) {
        long mod = (long)1e9 + 7;
        long[] dp = new long[num_people / 2 + 1];
        dp[0] = 1l;
        for (int k = 1; k <= num_people / 2; k++) {
        	for (int i = 0; i < k; i++) {
        		dp[k] = (dp[k] + (dp[i] * dp[k - i - 1]) % mod) % mod;
        	}
        }
        return (int)dp[dp.length - 1];
    }
}
