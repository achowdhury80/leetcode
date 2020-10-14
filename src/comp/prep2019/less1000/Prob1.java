package comp.prep2019.less1000;
import java.util.*;
public class Prob1 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(target - nums[i])) return new int[] {
        			map.get(target - nums[i]), i};
        	else {
        		map.put(nums[i], i);
        	}
        }
        return null;
    }
	
}
