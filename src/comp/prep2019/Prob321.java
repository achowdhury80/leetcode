package comp.prep2019;

public class Prob321 {
	/**
	 * O((MN)^2)
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int n = nums1.length, m = nums2.length;
        for (int i = Math.max(0, (k - m)); i <= k && i <= n; i++) {
        	int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
        	if (isGreater(candidate, 0, result, 0)) result = candidate;
        }
        return result;
    }
	
	private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

	private boolean isGreater(int[] num1, int i, int[] num2, int j) {
		while(i < num1.length && j < num2.length && num1[i] == num2[j]) {
			i++;
			j++;
		}
		return j == num2.length || (i < num1.length && num1[i] > num2[j]);
	}
	
	private int[] maxArray(int[] nums, int k) {
		int[] result = new int[k];
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			while(idx > 0 && result[idx - 1] < nums[i] 
					&&  (nums.length - i) > (k - idx)) idx--;
			if (idx < k) result[idx++] = nums[i];
		}
	
		return result;
	}
	
	public static void main(String[] args) {
		Prob321 prob = new Prob321();
		System.out.println(prob.maxNumber(new int[] {3, 4, 6, 5}, 
				new int[] {9, 1, 2, 5, 8, 3}, 5));
	}
}
