package comp.prep2019;
import java.util.*;
public class Prob494 {
	public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        map.put(-nums[0], 1);
        if (nums[0] == 0) map.put(0, 2);
        for (int i = 1; i < nums.length; i++) {
        	Map<Integer, Integer> temp = new HashMap<>();
        	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        		int val1 = entry.getKey() + nums[i], val2 = entry.getKey() - nums[i];
        		temp.put(val1, temp.getOrDefault(val1, 0) + entry.getValue());
        		temp.put(val2, temp.getOrDefault(val2, 0) + entry.getValue());
        	}
        	map = temp;
        }
        return map.containsKey(S) ? map.get(S) : 0;
    }
	
	public static void main(String[] args) {
		Prob494 prob = new Prob494();
		System.out.println(prob.findTargetSumWays(new int[] {1, 1,1,1,1}, 3));
	}
}
