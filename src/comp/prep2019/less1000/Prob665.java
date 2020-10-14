package comp.prep2019.less1000;

public class Prob665 {
	/**
	 * O(N) time
	 * for each element compare with prev element
	 * if it is smaller, check the prev element can be reduced
	 * else increase cur element
	 * u can do it once only
	 * @param nums
	 * @return
	 */
	public boolean checkPossibility(int[] nums) {
		boolean used = false;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] < nums[i - 1]) {
        		if (used) return false;
        		if (i < 2 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i];
        		else nums[i] = nums[i - 1];
        		used = true;
        	}
        }
        return true;
    }
}
