package comp.prep2019.less1000;

public class Prob940 {
	public int distinctSubseqII(String S) {
        int mod = (int)(1e9 + 7);
        int n = S.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) last[i] = -1;
        for (int i = 0; i < n; i++) {
        	dp[i + 1] =  (2 * dp[i]) % mod;
        	int c = S.charAt(i) - 'a';
        	if (last[c] > -1) dp[i + 1] -= dp[last[c]];
        	dp[i+1] %= mod;
        	last[c] = i;
        }
        dp[n]--;
        if (dp[n] < 0) dp[n] += mod;
        return dp[n];
    }
}
