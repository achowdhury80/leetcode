package comp.prep2019.less1000;

public class Prob213 {
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length < 2) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
	
	private int rob(int[] nums, int start, int end) {
		if (start == end) return nums[start];
		int[] last = new int[] {nums[start], Math.max(nums[start], nums[start + 1])};
		int cur = 0;
		for (int i = start + 2; i <= end; i++) {
			cur = Math.max(nums[i] + last[0], last[1]);
			last[0] = last[1];
			last[1] = cur;
		}
		return Math.max(last[0], last[1]);
	}
}
