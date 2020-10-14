package comp.prep2019;

public class Prob1493 {
	public int longestSubarray(int[] nums) {
        int lastZeroIndex = -1, start = -1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		result = Math.max(result, i - start - 2);
        		start = lastZeroIndex;
        		lastZeroIndex = i;
        	}
        }
        if (nums[nums.length - 1] == 1) result = Math.max(result, nums.length - 1 - start - 1);
        return result == Integer.MIN_VALUE ? 0 : result;
    }
}
