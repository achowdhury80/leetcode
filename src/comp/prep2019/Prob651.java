package comp.prep2019;

public class Prob651 {
	public int maxA(int N) {
	    int[] dp = new int[N + 1];
	    for (int i = 1; i <= N; i++){
	      dp[i] = i;
	      for (int j = 1; j <= i - 3; j++){
	        dp[i] = Math.max(dp[i], (i - j - 1) * dp[j]);
	      }
	    }
	    return dp[N];
	  }
}
