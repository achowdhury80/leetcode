package comp.prep2019;
public class Prob264 {
	/**
	 * O(N) time and space
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
	    if(n < 1) return 0;
	    int[] dp = new int[n + 1];
	    dp[1] = 1;
	    int factor2_last = 1;
	    int factor3_last = 1;
	    int factor5_last = 1;
	    for(int i = 2; i <= n; i++){
	      int nextNumber = Math.min(dp[factor2_last] * 2, Math.min(dp[factor3_last] * 3, dp[factor5_last] * 5));
	      dp[i] = nextNumber;
	      if(nextNumber == dp[factor2_last] * 2){
	        factor2_last++;
	      }
	      if(nextNumber == dp[factor3_last] * 3){
	        factor3_last++;
	      }
	      if(nextNumber == dp[factor5_last] * 5){
	        factor5_last++;
	      }

	    }
	    return dp[n];
	  }
}
