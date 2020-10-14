package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob16 {
	/**
	 * O(N^2)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer result = null;
        for (int i = 0; i < nums.length - 2; i++) {
        	int closest = find2SumClosest(nums, i + 1, nums.length - 1, target - nums[i]);
        	if (result == null || Math.abs(target - result) > Math.abs(nums[i] + closest - target)) {
        		result = nums[i] + closest;
        		if (result == target) return result;
        	}
        }
        return result;
    }
	
	private int find2SumClosest(int[] nums, int start, int end, int target) {
		Integer result = null;
		while(start < end) {
			int sum = nums[start] + nums[end];
			if (sum == target) return target;
			else if (sum > target) {
				end--;
			} else {
				start++;
			}
			if (result == null || Math.abs(result - target) > Math.abs(sum - target)) result = sum;
		}
		return result;
	}
}
