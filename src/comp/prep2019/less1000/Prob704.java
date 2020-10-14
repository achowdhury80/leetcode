package comp.prep2019.less1000;

public class Prob704 {
	public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while(l <= h) {
        	int mid = l + (h - l) / 2;
        	if (nums[mid] == target) return mid;
        	if (nums[mid] > target) h = mid - 1;
        	else l = mid + 1;
        }
        return -1;
    }
}
