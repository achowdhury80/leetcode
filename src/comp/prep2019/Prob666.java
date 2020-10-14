package comp.prep2019;

import java.util.*;

public class Prob666 {
	public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = nums.length - 1; i > -1; i--) {
        	int key = nums[i] / 10;
        	int freq = map.getOrDefault(key, 1);
        	result += nums[i] % 10 * freq;
        	int parentKey = (key / 10 - 1) * 10 + (key % 10 + 1) / 2 ;
        	map.put(parentKey, map.getOrDefault(parentKey, 0) + freq);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob666 prob = new Prob666();
		System.out.println(prob.pathSum(new int[] {113, 215, 221}));
	}
}
