package comp.prep2019;

public class Prob375 {
	public int getMoneyAmount(int n) {
	    if(n < 2) return 0;
	    int[][] dp = new int[n + 1][n + 1];
	    return getMoneyAmount(dp, 1, n);
	  }

	  public int getMoneyAmount(int[][] dp, int start, int end){
	    if(start >= end) return 0;
	    if(dp[start][end] != 0) return dp[start][end];
	    int cost = Integer.MAX_VALUE;
	    for(int i = start; i <= end; i++){
	      int tmp = i + Math.max(getMoneyAmount(dp, start, i - 1), getMoneyAmount(dp, i + 1, end));
	      cost = Math.min(cost, tmp);
	    }
	    dp[start][end] = cost;
	    return dp[start][end];
	  }
}
