package comp.prep2019.less2000;

public class Prob1437 {
	public boolean kLengthApart(int[] nums, int k) {
		if (k == 0) return true;
		int last = -1;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 1) {
        		if (last != -1 && i - last - 1 < k) return false;
        		last = i;
        	}
        }
        return true;
    }
}
