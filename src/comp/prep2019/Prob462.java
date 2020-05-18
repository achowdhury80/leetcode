package comp.prep2019;

import java.util.Arrays;

public class Prob462 {
	public int minMoves2(int[] nums) {
	    Arrays.sort(nums);
	    int i = 0, j = nums.length -1, count = 0;
	    while(i < j) count += nums[j--] - nums[i++];
	    return count;
	  }
}
