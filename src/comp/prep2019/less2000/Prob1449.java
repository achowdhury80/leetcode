package comp.prep2019.less2000;

public class Prob1449 {
	public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
        	dp[i] = Integer.MIN_VALUE;
        	for (int c : cost) {
        		if (i >= c) {
        			dp[i] = Math.max(dp[i], 1 + dp[i - c]);
        		}
        	}
        }
        if (dp[target] < 1) return "0";
        int t = target;
        StringBuilder result = new StringBuilder();
        for (int i = 8; i > -1; i--) {
        	while (t >= cost[i] && dp[t] == 1 + dp[t - cost[i]]) {
        		t -= cost[i];
        		result.append(i + 1);
        	}
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		Prob1449 prob = new Prob1449();
		System.out.println(prob.largestNumber(new int[] {4,3,2,5,6,7,2,5,5}, 9));
	}
}
