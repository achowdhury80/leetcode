package comp.prep2019.less1000;

public class Prob644 {
	public double findMaxAverage(int[] nums, int k) {
        double l = nums[0], r = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	l = Math.min(l, nums[i]);
        	r = Math.max(r, nums[i]);
        }
      //start with mid average
        // find out if we have a subarray with avg >= mid average
        // if yes, move l to m
        // else move r to m
        while (l + 1e-5 < r) {
        	double mid = l + (r - l) / 2;
        	if (canFind(nums, k, mid)) l = mid;
        	else r = mid;
        }
        return l;
    }

	/**
	 * finds if a subArray with length >= k has avg >= m
	 * @param nums
	 * @param k
	 * @param m
	 * @return
	 */
	private boolean canFind(int[] nums, int k, double m) {
		double minLeftSum = 0, rightSum = 0, leftSum = 0;
		// find sum of deviation(nums[i] - m) for first k element
		//if it is greater than 0, that means avg exist
		for (int i = 0; i < k; i++) {
			rightSum += nums[i] - m;
		}
		for (int i = k; i < nums.length; i++) {
			//if it is greater than 0, that means avg exist
			if (rightSum - minLeftSum >= 0) return true;
			rightSum += nums[i] - m;
			//compute left sum
			leftSum += nums[i - k] - m;
			minLeftSum = Math.min(minLeftSum, leftSum);
		}
		return rightSum - minLeftSum >= 0;
	}
}
