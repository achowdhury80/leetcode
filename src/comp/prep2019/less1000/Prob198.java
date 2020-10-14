package comp.prep2019.less1000;

public class Prob198 {
	/**
	 * o(N) timw and O(1) space
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //dp[i] is the max sum till ith element. May or may not include ith element
        //we keep only the last two dp element
        int[] dp = new int[] {nums[0], Math.max(nums[0], nums[1])};
        for (int i = 2; i < nums.length; i++) {
        	int temp = Math.max(dp[0] + nums[i], dp[1]);
        	dp[0] = dp[1];
        	dp[1] = temp;
        }
        return dp[1];
    }
}
