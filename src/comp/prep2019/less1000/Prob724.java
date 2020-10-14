package comp.prep2019.less1000;

public class Prob724 {
	public int pivotIndex(int[] nums) {
        if (nums.length < 1) return -1;
        if (nums.length == 1) return 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) sum[i] = sum[i - 1] + nums[i];
        for (int i = 0; i < nums.length; i++) {
        	int left = i == 0 ? 0 : sum[i - 1];
        	int right = i == nums.length - 1 ? 0 : sum[nums.length - 1] - sum[i];
        	if (left == right) return i;
        }
        return -1;
    }
}
