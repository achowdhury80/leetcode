package comp.prep2019;

import java.util.Arrays;

public class Prob611 {
	/**
	 * O(N^2 logn)
	 * @param nums
	 * @return
	 */
	public int triangleNumber(int[] nums) {
		int n = nums.length;
		if (n < 3) return 0;
		Arrays.sort(nums);
		int result = 0;
		for (int i = n - 1; i > 1; i--) {
			int l = 0, r = i - 1;
			while(l < r) {
				if (nums[l] + nums[r] > nums[i]) {
					result += (r - l);
					r--;
				} else l++;
			}
		}
		return result;
    }
}
