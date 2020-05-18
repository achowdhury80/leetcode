package comp.prep2019;

public class Prob35 {
	public int searchInsert(int[] nums, int target) {
        if (nums.length < 1) return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
        	int mid = l + (h - l) / 2;
        	if (nums[mid] == target) return mid;
        	if (nums[mid] > target) h = mid;
        	else l = mid + 1;
        }
        return nums[l] < target ? l + 1 : l;
    }
}
