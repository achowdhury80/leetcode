package comp.prep2019.less1000;

public class Prob31 {
	 public void nextPermutation(int[] nums) {
			int n = nums.length;
			if (n < 2) return;
			for (int i = n - 2; i > -1; i--) {
	        	if (nums[i] <  nums[i + 1]) {
	        		if (nums[n - 1] > nums[i]) {
	        			swap(nums, i, n - 1);
	        		} else {
	        			for (int j = i + 1; j < n - 1; j++) {
	        				if (nums[i] >= nums[j + 1] && nums[i] < nums[j]) {
	        					swap(nums, i, j);
	        					break;
	        				}
	        			}
	        		}
	        		reverse(nums, i + 1, nums.length - 1);
	        		return;
	        	}
	        }
	        reverse(nums, 0, n - 1);
	    }
		
		private void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		
		private void reverse(int[] nums, int i , int j) {
			while(i < j) {
				swap(nums, i, j);
				i++;
				j--;
			}
		}
	
}
