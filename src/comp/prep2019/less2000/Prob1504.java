package comp.prep2019.less2000;

public class Prob1504 {
	public int numSubmat(int[][] mat) {
        int[][][] dp = new int[mat.length][mat[0].length][4];
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
        	for (int j = 0; j < mat[0].length; j++) {
        		if (mat[i][j] == 1) {
        			for (int k = 0; k < 4; k++) dp[i][j][k] = 1;
        			result += 1;
        			if (j > 0 && dp[i][j - 1][0] > 0) {
        				dp[i][j][0] += dp[i][j - 1][0];
        				result += dp[i][j - 1][0];
        			}
        			if (i > 0 && dp[i - 1][j][1] > 0) {
        				dp[i][j][1] += dp[i - 1][j][1];
        				result += dp[i - 1][j][1];
        			}
        			if (i > 0 && j > 0 && dp[i - 1][j - 1][2] > 0 
        					&& dp[i - 1][j - 1][3] > 0) {
        				dp[i][j][2] = 1 + Math.min(dp[i][j][0] - 1, 
        						dp[i - 1][j - 1][2]);
        				dp[i][j][3] = 1 + Math.min(dp[i][j][1] - 1, 
        						dp[i - 1][j - 1][3]);
        				result += (dp[i][j][2] - 1) * (dp[i][j][3] - 1);
        			}
        			
        		}
        		
        	}
        }
        return result;
    }
}
