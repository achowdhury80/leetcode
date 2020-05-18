package comp.prep2019;

public class Prob474 {
	public int findMaxForm(String[] strs, int m, int n) {
		int len;
	    if(strs == null || m < 0 || n < 0 || (len = strs.length) == 0) return 0;
	    int[][][] dp = new int[m + 1][n + 1][len + 1];
	    for(int j = 1; j <= len; j++){
	        String st = strs[j - 1];
	        int oneCount = 0;
	        for (char c : st.toCharArray()) {
	        	if (c == '1') oneCount++;
	        }
	        int zeroCount = st.length() - oneCount;
	        for (int numZeros = 0; numZeros <= m; numZeros++) {
	        	for (int numOnes = 0; numOnes <= n; numOnes++) {
	        		if (numZeros == 0 && numOnes == 0) {
	        			dp[0][0][j] = 0;
	        			continue;
	        		}
	        		dp[numZeros][numOnes][j] = dp[numZeros][numOnes][j - 1];
	                if(oneCount <= numOnes && zeroCount <= numZeros){
	                  dp[numZeros][numOnes][j] = Math.max(dp[numZeros][numOnes][j], 
	                		  dp[numZeros - zeroCount][numOnes - oneCount][j - 1] 
	                				  + 1);
	                }
	        	}
	        }
	    }
	    return dp[m][n][len];
    }
}
