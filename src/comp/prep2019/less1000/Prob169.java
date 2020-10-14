package comp.prep2019.less1000;

public class Prob169 {
	public int majorityElement(int[] nums) {
        int result = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (result == nums[i]) count++;
        	else {
        		count--;
        		if (count == 0) {
        			result = nums[i];
        			count = 1;
        		}
        	}
        }
        return result;
    }
}
