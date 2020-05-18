package comp.prep2019;

public class Prob673 {
	public int findNumberOfLIS(int[] nums) {
		if (nums.length < 1) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0] = new int[] {1, 1};
        int[] result = new int[] {1, 1};
        for (int i = 1; i < nums.length; i++) {
        	dp[i] = new int[] {1, 1};
        	for (int j = i - 1; j > -1; j--) {
        		if (nums[j] < nums[i]) {
        			if (1 + dp[j][0] > dp[i][0]) {
        				dp[i] = new int[] {1 + dp[j][0], dp[j][1]};
        			} else if (1 + dp[j][0] == dp[i][0]) {
        				dp[i][1] += dp[j][1];
        			}
        		}
        	}
        	if (result[0] < dp[i][0]) {
        		result[0] = dp[i][0];
        		result[1] = dp[i][1];
        	} else if (result[0] == dp[i][0]) result[1] += dp[i][1];
        }
        return result[1];
    }
	
	public static void main(String[] args) {
		Prob673 prob = new Prob673();
		System.out.println(prob.findNumberOfLIS(new int[] {1, 3, 5, 4, 7}));
	}
}
