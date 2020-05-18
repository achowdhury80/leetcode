package comp.prep2019;

public class Prob53 {
	/**
	 * O(N)
	 * set sum to 0 if sum is negative
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE, sum = 0;
        for(int i : nums) {
        	sum += i;
        	result = Math.max(result, sum);
        	if (sum < 0) sum = 0;
        }
        return result;
    }
}
