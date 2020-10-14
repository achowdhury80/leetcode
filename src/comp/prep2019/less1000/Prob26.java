package comp.prep2019.less1000;

public class Prob26 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		if(nums.length < 2) return nums.length;
        int idx = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] != last) {
        		nums[idx++] = nums[i];
        		last = nums[i];
        	}
        }
        return idx;
    }
}
