package comp.prep2019.less1000;

public class Prob287 {
	public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
        	int cur = Math.abs(nums[i]);
        	if (nums[cur - 1] < 0) return cur;
        	nums[cur - 1] *= -1;
        }
        return -1;
    }
}
