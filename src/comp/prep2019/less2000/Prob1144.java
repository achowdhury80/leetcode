package comp.prep2019.less2000;

public class Prob1144 {
	public int movesToMakeZigzag(int[] nums) {
        return Math.min(helper(nums, 0), helper(nums, 1));
    }
	
	/**
	 * lower values can 0, 2, 4.. index
	 * or 1, 3, 5..index
	 * @param nums
	 * @param lowerIndex
	 * @return
	 */
	private int helper(int[] nums, int lowerIndex) {
		int result = 0;
		for (int i = lowerIndex; i < nums.length; i += 2) {
			int moveForLeft = 0;
			if (i > 0 && nums[i - 1] <= nums[i]) {
				moveForLeft = nums[i] - nums[i - 1] + 1;
			}
			int moveForRight = 0;
			if (i < nums.length - 1 && nums[i + 1] <= nums[i]) {
				moveForRight = nums[i] - nums[i + 1] + 1;
			}
			result += Math.max(moveForLeft, moveForRight);
		}
		return result;
	}
}
