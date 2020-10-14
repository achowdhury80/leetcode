package comp.prep2019.less1000;

public class Prob643 {
	public double findMaxAverage(int[] nums, int k) {
		int sum = 0;
        for (int i = 0; i < k; i++) {
        	sum += nums[i];
        }
        double result = (sum + 0.0) / k;
        for (int i = k; i < nums.length; i++) {
        	sum += nums[i] - nums[i - k];
        	result = Math.max(result, (sum + 0.0) / k);
        }
        return result;
    }
}
