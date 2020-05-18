package comp.prep2019;
public class Prob920 {
	/**
	 * https://leetcode.com/problems/number-of-music-playlists/solution/
	 * @param N
	 * @param L
	 * @param K
	 * @return
	 */
	public int numMusicPlaylists(int N, int L, int K) {
		int MOD = (int)(1e9 + 7);
		long[][] dp = new long[L + 1][N + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j - 1] * (N - j + 1);
				dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0); 
				dp[i][j] %= MOD;
			}
		}
		return (int)dp[L][N];
    }
	
	
	
	public static void main(String[] args) {
		Prob920 prob = new Prob920();
		System.out.println(prob.numMusicPlaylists(3, 3, 1));
		System.out.println(prob.numMusicPlaylists(3, 3, 0));
		System.out.println(prob.numMusicPlaylists(4, 4, 0));
	}
	
}
