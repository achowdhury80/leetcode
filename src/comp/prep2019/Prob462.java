package comp.prep2019;

import java.util.Arrays;

public class Prob462 {
	/**
	 * O(N)
	 * need a point in the middle, not necessary median
	 * @param nums
	 * @return
	 */
	public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int result = 0;
        while(i < j) {
        	result += nums[j--] - nums[i++];
        }
        return result;
    }
}
