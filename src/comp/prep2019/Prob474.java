package comp.prep2019;

public class Prob474 {
	public int findMaxForm(String[] strs, int m, int n) {
		int len;
	    if(strs == null || m < 0 || n < 0 || (len = strs.length) == 0) return 0;
	    int[][][] dp = new int[m + 1][n + 1][len + 1];
	    for (int j = 1; j <= len; j++) {
	    	int oneCount = 0;
	    	for (char c : strs[j - 1].toCharArray()) {
	    		if (c == '1') oneCount++;
	    	}
	    	int zeroCount = strs[j - 1].length() - oneCount;
	    	for (int numZeros = 0; numZeros <= m; numZeros++) {
	    		for (int numOnes = 0; numOnes <= n; numOnes++) {
	    			if (numZeros == 0 && numOnes == 0) continue;
	    			dp[numZeros][numOnes][j] = dp[numZeros][numOnes][j - 1];
	    			if (oneCount <= numOnes && zeroCount <= numZeros) {
	    				dp[numZeros][numOnes][j] = Math.max(dp[numZeros][numOnes][j],
	    						1 + dp[numZeros - zeroCount][numOnes - oneCount]
	    								[j - 1]);
	    			}
	    		}
	    	}
	    }
	    return dp[m][n][len];
    }
}
