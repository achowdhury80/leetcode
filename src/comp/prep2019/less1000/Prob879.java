package comp.prep2019.less1000;

public class Prob879 {
	/**
	 * https://leetcode.com/problems/profitable-schemes/solution/
	 * @param G
	 * @param P
	 * @param group
	 * @param profit
	 * @return
	 */
	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
		int n = profit.length;
        long[][][] dp = new long[2][P + 1][G + 1];
        dp[0][0][0] = 1;
        long mod = (long)(1e9 + 7);
        for (int i = 0; i < n; i++) {
        	int p0 = profit[i], g0 = group[i];
        	long[][] cur = dp[i % 2], cur2 = dp[(i + 1) % 2];
        	for (int x = 0; x <= P; x++) {
        		for (int y = 0; y <= G; y++) {
        			cur2[x][y] = cur[x][y];
        		}
        	}
        	for (int jp = 0; jp <= P; jp++) {
        		int p = Math.min(P, p0 + jp);
        		for (int jg = 0; jg <= G - g0; jg++) {
        			int g = jg + g0;
        			cur2[p][g] = (cur2[p][g] + cur[jp][jg]) % mod;
        		}
        	}
        }
        
        long result = 0;
        for (long x : dp[n % 2][P]) {
        	result = (result + x) % mod;
        }
        return (int)result;
    }
}
