package comp.prep2019;

public class Prob689 {
	/**
	 * O(N) time and space
	 * first find interval(k) sum 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] w = new int[nums.length - k + 1];
        int sum = 0, idx = 0;
        //interval sum starting from 0th till n - kth element
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (i >= k) sum -= nums[i - k];
        	if (i >= k - 1) w[idx++] = sum;
        }
        // left[i] gives the lowest index of the max interval value 
        //till i of W
        // right[i] gives the lowest index of max interval value 
        // starting from ith till the end
        int[] left = new int[w.length], right = new int[w.length];
        left[0] = 0;
        right[w.length - 1] = w.length - 1;
        for (int i = 1; i < w.length; i++) {
        	if (w[i] > w[left[i - 1]]) left[i] = i;
        	else left[i] = left[i - 1];
        	if (w[w.length - i - 1] >= w[right[w.length - i]]) 
        		right[w.length - i - 1] = w.length - i - 1;
        	else right[w.length - i - 1] = right[w.length - i];
        }
        int best = Integer.MIN_VALUE;
        int[] result = new int[] {-1, -1, -1};
        // now take the middle index from kth index of w 
        // till w.length - k - 1
        // find best case
        for (int j = k; j + k < w.length; j++) {
        	int cur = w[left[j - k]] + w[j] + w[right[j + k]];
        	if (cur > best) {
        		result = new int[] {left[j - k], j, right[j + k]};
        		best = cur;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob689 prob = new Prob689();
		int[] result = prob.maxSumOfThreeSubarrays(
				new int[] {1,2,1,2,6,7,5,1}, 2);
		for (int i : result) System.out.print(i + ", ");
	}
}
