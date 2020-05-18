package comp.prep2019;

public class Prob154 {
	public int findMin(int[] nums) {
        int n;
        if ((n = nums.length) < 2) return nums[0];
        int low = 0, high = n - 1;
        while (low < high) {
        	int mid = low + (high - low) / 2;
        	if (nums[mid] > nums[high]) low = mid + 1;
        	else if (nums[mid] < nums[low]) high = mid;
        	else if (nums[mid] == nums[high]) high--;
        	else if (mid != low && nums[mid] == nums[low]) low++;
        	else return nums[low];
        }
        return nums[low];
    }
}
