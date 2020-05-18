package comp.prep2019;

public class Prob303 {
	private int[] nums;
	public Prob303(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++) {
        	nums[i] += nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i < 0 || j >= nums.length) return 0;
        return nums[j] - (i > 0 ? nums[i - 1] : 0);
    }
}
