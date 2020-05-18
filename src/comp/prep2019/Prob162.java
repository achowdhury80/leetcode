package comp.prep2019;

public class Prob162 {
	public int findPeakElement(int[] nums) {
        if (nums.length < 2) return 0;
        int l = 0, r = nums.length - 1;
        while(l < r - 1) {
        	int mid = l + (r - l) / 2;
        	if (nums[mid] <= nums[l]) r = mid - 1;
        	else if (nums[mid] <= nums[r]) l = mid + 1;
        	else {
        		if (nums[mid + 1] > nums[mid]) l = mid + 1;
        		else r = mid;
        	}
        }
        return nums[l] > nums[r] ? l : r;
    }
}
