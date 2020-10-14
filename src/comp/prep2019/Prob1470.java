package comp.prep2019;

public class Prob1470 {
	/**
	 * O(n) time and space
	 * @param nums
	 * @param n
	 * @return
	 */
	public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int i = 0, j = n;
        int idx = 0;
        while(i < n) {
        	result[idx++] = nums[i];
        	result[idx++] = nums[j];
        	i++;
        	j++;
        }
        return result;
    }
}
