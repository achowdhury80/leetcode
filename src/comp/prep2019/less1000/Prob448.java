package comp.prep2019.less1000;
import java.util.*;
public class Prob448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
        	int d = Math.abs(nums[i]);
        	if (nums[d - 1] > 0) nums[d - 1] *= (-1);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}
