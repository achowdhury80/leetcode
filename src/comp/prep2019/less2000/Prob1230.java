package comp.prep2019.less2000;

public class Prob1230 {
	/**
	 * dp[i][j] = getting i heads using first j coins ... 1 based
	 * dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] * prob(j - 1)
	 * dp[0][0] = 1
	 * dp[i][0] = 0
	 * dp[0][1] = 1 - prob[0]
	 * @param prob
	 * @param target
	 * @return
	 */
	public double probabilityOfHeads(double[] prob, 
			int target) {
        if (target > prob.length || target < 0) return 0;
        double[][] dp = new double[target + 1][prob.length + 1];
        dp[0][0] = 1;
        dp[0][1] = 1 - prob[0];
        for (int j = 2; j <= prob.length; j++) {
        	dp[0][j] = dp[0][j - 1] * (1 - prob[j - 1]);
        }
        for (int i = 1; i <= target; i++) {
        	for (int j = 1; j <= prob.length; j++) {
        		if (i > j) {
        			continue;
        		}
        		dp[i][j] = dp[i][j - 1] * (1 - prob[j - 1]) + dp[i - 1][j - 1] * prob[j - 1];
        	}
        }
        return dp[target][prob.length];
    }
	
	public static void main(String[] args) {
		Prob1230 prob = new Prob1230();
		System.out.println(prob.probabilityOfHeads(new double[] {0.4}, 1));
		System.out.println(prob.probabilityOfHeads(new double[] {1, 1}, 1));
	}
}
