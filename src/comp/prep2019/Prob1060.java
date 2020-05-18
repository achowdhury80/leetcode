package comp.prep2019;

public class Prob1060 {
	public int missingElement(int[] nums, int k) {
       int n = nums.length;
       int numRange = nums[nums.length - 1] - nums[0] + 1;
       int missing = numRange - n;
       if (k > missing) {
    	   return nums[nums.length - 1] + k - missing;
       }
       return find(nums, k, 0, n - 1);
    }
	
	private int find(int[] nums, int k, int start, int end) {
		while(start < end - 1) {
			int mid = start + (end - start) / 2;
			int numRange = nums[mid] - nums[start] + 1;
			int n = mid - start + 1;
			int missing = numRange - n;
			if (missing >= k) {
				end = mid;
			} else {
				k -= missing;
				start = mid;
			}
		}
		return nums[start] + k;
	}
}
