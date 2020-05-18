package comp.prep2019;

public class Prob1223 {
	public int dieSimulator(int n, int[] rollMax) {
		int mod = (int)(1e9 + 7);
        long[][] dp = new long[16][7];
        for (int i = 1; i < 7; i++) dp[1][i] = 1;
        for (int i = 1; i < n; i++) {
        	for (int j = 1; j < 7; j++) {
        		long[] temp = new long[Math.min(n, rollMax[j])];
        		for (int k = 1; k <= temp.length; k++) {
        			if (k > 1) temp[k] = dp[k - 1][j];
        			else {
        				long sum = 0;
        				for (int l = 1; l < 7; l++) {
        					if (j == l) continue;
        				}
        			}
        		}
        	}
        }
        long result = 0;
        return 0;
    }
}
