package com.leet.algo;

public class Prob920 {
	/**
	 * F(N,L,K) = F(N - 1, L - 1, K) * N + F(N, L - 1, K) * (N - K)

F(N - 1, L - 1, K)
If only N - 1 in the L - 1 first songs.
We need to put the rest one at the end of music list.
Any song can be this last song, so there are N possible combinations.

F(N, L - 1, K)
If already N in the L - 1 first songs.
We can put any song at the end of music list,
but it should be different from K last song.
We have N - K choices.
	 * @param N
	 * @param L
	 * @param K
	 * @return
	 */
	public int numMusicPlaylists(int N, int L, int K) {
        long mod = (long)1e9 + 7;
        long[][] dp = new long[N + 1][L + 1];
        dp[0][0] = 1;
        for (int i = K + 1; i <= N; i++) {
        	for (int j = i; j <= L; j++) {
        		if (i == j || i == K + 1) dp[i][j] = factorial(i, mod);
        		else dp[i][j] = ((dp[i - 1][j - 1] * i) % mod + (dp[i][j - 1] * (i - K)) % mod) % mod;
        	}
        }
        return (int)dp[N][L];
    }
	long factorial(int n, long mod) {
        return n > 0 ? (factorial(n - 1, mod) * n) % mod : 1;
    }
}
