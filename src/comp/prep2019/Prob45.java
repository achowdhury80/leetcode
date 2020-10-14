package comp.prep2019;

public class Prob45 {
	/**
	 * O(N) time and O(1) space
	 * 
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		int n = nums.length;
	    if (n < 2) return 0;
        int maxPos = nums[0], maxSteps = nums[0], jump = 1;
        for (int i = 1; i < n; i++) {
        	// current jump situation is not allowing to reach
        	// we need one more jump
        	if (maxSteps < i) {
        		jump++;
        		maxSteps = maxPos;
        	}
        	// each new position gives an opportunity to get to next farthest 
        	//position
        	maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jump;
    }
	public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
        	for (int j = 1; j <= nums[i] && (i + j) < nums.length; j++) {
        		dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
        	}
        }
        return dp[nums.length - 1];
    }
	
}
