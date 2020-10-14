package comp.prep2019;

public class Prob540 {
	/**
	 * O(logN)
	 * @param nums
	 * @return
	 */
	public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
        	int mid = left + (right -left) / 2;
        	if (mid % 2 == 1) {
        		if (nums[mid] == nums[mid - 1]) left = mid + 1;
        		else right = mid - 1;
        	} else {
        		if (nums[mid - 1] == nums[mid]) right = mid - 2;
        		else if (nums[mid] == nums[mid + 1]) left = mid + 2;
        		else return nums[mid];
        	}
        }
        return nums[left];
    }
}
