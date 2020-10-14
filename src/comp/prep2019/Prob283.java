package comp.prep2019;

public class Prob283 {
	/**
	 * O(N)
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != 0) {
        		nums[idx++] = nums[i];
        	}
        }
        while(idx < nums.length) {
        	nums[idx++] = 0;
        }
    }
}
