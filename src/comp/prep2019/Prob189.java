package comp.prep2019;

public class Prob189 {
	/**
	 * O(N) time
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return;
        k %= n;
        if (k == 0) return;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
	
	private void reverse(int[] nums, int i, int j) {
		while(i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}
