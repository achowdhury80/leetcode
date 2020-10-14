package comp.prep2019.less1000;



public class Prob487 {
	public int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int start = 0;
		int lastZeroIndex = -1;
		int i = 0;
		for( i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (lastZeroIndex == -1) {
					lastZeroIndex = i;
				} else {
					result = Math.max(result, i - start);
					start = lastZeroIndex + 1;
					lastZeroIndex = i;
				}
			}
		}
		result = Math.max(result, i - start);
		return result;
    }
}
