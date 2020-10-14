package comp.prep2019;

public class Prob162 {
	/**
	 * O(logn)
	 * nums[i] and nums[i + 1] not equal
	 * @param nums
	 * @return
	 */
	public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low + 1 < high) {
        	int mid = low + (high -low) / 2;
        	if (nums[mid] <= nums[low]) high = mid - 1;
        	else if (nums[mid] <= nums[high]) low = mid + 1;
        	else {
        		if (nums[mid + 1] > nums[mid]) low = mid + 1;
        		else high = mid;
        	}
        }
        return nums[low] < nums[high] ? high : low;
    }
}
