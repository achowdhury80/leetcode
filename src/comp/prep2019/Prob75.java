package comp.prep2019;

public class Prob75 {
	
	public void sortColors(int[] nums) {
        int smaller = -1, eq = 0, larger = nums.length;
        while(eq < larger) {
        	if (nums[eq] == 1) eq++;
        	else if (nums[eq] > 1) swap(nums, eq, --larger);
        	else swap(nums, ++smaller, eq++);
        }
    }
	
	public void sortColors1(int[] nums) {
        int left = -1, right = nums.length;
        for (int i = 0; i < right; i++) {
        	if (nums[i] == 2) {
        		swap(nums, i, --right);
        		i--;
        	} else if (nums[i] == 0) {
        		swap(nums, ++left, i);
        	}
        }
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
