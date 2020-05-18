package comp.prep2019;

public class Prob473 {
	public boolean makesquare(int[] nums) {
		if (nums.length < 4) return false;
        int sum = nums[0], max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
        	sum += nums[i];
        	max = Math.max(max, nums[i]);
        }
        if (sum % 4 != 0) return false;
        if (max > (sum / 4)) return false;
        return helper(nums, new int[] {0, 0, 0, 0}, sum / 4, 0);
    }
	
	private boolean helper(int[] nums, int[] subsetSum, int sum, int start) {
		if (start == nums.length) {
			for (int sub : subsetSum) {
				if (sub != sum) return false;
			}
			return true;
		}
		for (int j = 0; j < subsetSum.length; j++) {
			if (subsetSum[j] + nums[start] > sum) continue;
			subsetSum[j] += nums[start];
			if (helper(nums, subsetSum, sum, start + 1)) return true;
			subsetSum[j] -= nums[start];
		}
		return false;
	}
}
