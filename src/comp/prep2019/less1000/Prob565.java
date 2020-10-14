package comp.prep2019.less1000;
import java.util.*;
public class Prob565 {
	public int arrayNesting(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i]) continue;
        	Set<Integer> set = new HashSet<>();
        	set.add(nums[i]);
        	arr[i] = true;
        	int j = nums[i];
        	while(!set.contains(nums[j])) {
        		set.add(nums[j]);
        		arr[j] = true;
        		j = nums[j];
        	}
        	result = Math.max(result, set.size());
        }
        return result;
    }
}
