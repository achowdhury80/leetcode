package comp.prep2019.less1000;

public class Prob27 {
	public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != val) nums[idx++] = nums[i];
        }
        return idx;
    }
}
