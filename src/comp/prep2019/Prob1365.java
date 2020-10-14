package comp.prep2019;

public class Prob1365 {
	/**
	 * O(N) time and O(1) space
	 * @param nums
	 * @return
	 */
	public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        int count = 0;
        for (int i : nums) {
        	freq[i]++;
        	count++;
        }
        for (int i = 100; i > -1; i--) {
        	count -= freq[i];
        	freq[i] = count;
        }
        int[] result = new int[nums.length];
        for (int i = 0;  i < nums.length; i++) {
        	result[i] = freq[nums[i]];
        }
        return result;
    }
}
