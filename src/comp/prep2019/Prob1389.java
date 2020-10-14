package comp.prep2019;
import java.util.*;
public class Prob1389 {
	/**
	 * O(n) time and space
	 * @param nums
	 * @param index
	 * @return
	 */
	public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	list.add(index[i], nums[i]);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
