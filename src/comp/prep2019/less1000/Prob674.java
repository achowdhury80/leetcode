package comp.prep2019.less1000;

public class Prob674 {
	public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int result = 1, start = 0;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] <= nums[i - 1]) {
        		start = i;
        	} else {
        		result = Math.max(result, i - start + 1);
        	}
        }
        return result;
    }
}
