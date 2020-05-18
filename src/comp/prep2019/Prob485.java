package comp.prep2019;

public class Prob485 {
	public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) count = 0;
        	else {
        		count++;
        		result = Math.max(result, count);
        	}
        }
        return result;
    }
}
