package comp.prep2019;

public class Prob526 {
	public int countArrangement(int N) {
        if (N < 2) return N;
        int[] nums = new int[N + 1];
        for (int i = 0; i < nums.length; i++) nums[i] = i;
        return helper(nums, 1);
    }
	
	private int helper(int[] nums, int start) {
		if (start == nums.length) return 1;
		int result = 0;
		for (int i = start; i < nums.length; i++) {
			swap(nums, start, i);
			if (nums[start] % start == 0 || start % nums[start] == 0) {
				result += helper(nums, start + 1);
			}
			swap(nums, start, i);
		}
		return result;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
