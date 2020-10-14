package comp.prep2019;

public class Prob887 {
	/**
	 * dp[M][K] means number of floors can be covered with M moves and K eggs
	 * if k the eggs break, we cover dp[M - 1][K - 1] floor with M - 1 moves and 
	 * K- 1 eggs
	 * if it does not break we cover dp[M - 1][K - 1] + 1(since at this floor it 
	 * did not break) + additional dp[M - 1][K] floor.
	 * so, dp[M][K] = dp[M - 1][K - 1] + dp[M - 1][K]
	 * 
	 * For time, O(NK) decalre the space, O(KlogN) running,
	 * For space, O(NK).
	 * @param K
	 * @param N
	 * @return
	 */
	public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
        	m++;
        	for (int k = 1; k <= K; k++) {
        		dp[m][k] = dp[m - 1][k - 1] + 1 + dp[m - 1][k];
        	}
        }
        return m;
    }
}
