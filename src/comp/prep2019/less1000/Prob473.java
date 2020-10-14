package comp.prep2019.less1000;

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
        return helper(nums, new int[] {0, 0, 0, 0}, 0, sum / 4);
    }
	
	private boolean helper(int[] nums, int[] subsetSums, int start, int sum) {
		if (start == nums.length) {
			for (int subsetSum : subsetSums) if (subsetSum != sum) return false;
			return true;
		}
		for (int i = 0; i < 4; i++) {
			if (subsetSums[i] + nums[start] > sum) continue;
			subsetSums[i] += nums[start];
			if (helper(nums, subsetSums, start + 1, sum)) return true;
			subsetSums[i] -= nums[start];
		}
		return false;
	}
}
