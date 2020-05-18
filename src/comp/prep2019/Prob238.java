package comp.prep2019;

public class Prob238 {
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) result[i] = 1;
        for (int i = 0; i < nums.length; i++) {
        	result[i] *= left;
        	result[nums.length - i - 1] *= right;
        	left *= nums[i];
        	right *= nums[nums.length - i - 1];
        }
        return result;
    }
}
