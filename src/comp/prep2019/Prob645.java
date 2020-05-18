package comp.prep2019;

public class Prob645 {
	public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
        	int num = Math.abs(nums[i]);
        	if (nums[num - 1] < 0) result[0] = num;
        	else nums[num - 1] *= (-1);
        }
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > 0) {
        		result[1] = i + 1;
        		break;
        	}
        }
        return result;
    }
}
