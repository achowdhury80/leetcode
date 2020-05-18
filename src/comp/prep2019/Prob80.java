package comp.prep2019;

public class Prob80 {
	public int removeDuplicates(int[] nums) {
		if (nums.length < 3) return nums.length;
        int idx = 1;
        int count = nums[0] == nums[1] ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
        	if(nums[i] == nums[i - 1]) {
        		if (count < 2) {
        			count++;
        			nums[++idx] = nums[i];
        		}
        	} else {
        		count = 1;
        		nums[++idx] = nums[i];
        	}
        }
        return idx + 1;
    }
}
