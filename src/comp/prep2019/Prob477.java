package comp.prep2019;

public class Prob477 {
	public int totalHammingDistance(int[] nums) {
        int result = 0;
        if (nums == null || nums.length < 2) return result;
        for (int i = 0; i < 32; i++) {
        	int zeros = 0, ones = 0;
        	for (int num : nums) {
        		if (((num >> i) & 1) == 1) ones++;
        		else zeros++;
        	}
        	result += ones * zeros;
        }
        return result;
    }
}
