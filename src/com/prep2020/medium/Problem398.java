package com.prep2020.medium;
import java.util.*;
public class Problem398 {
	private Map<Integer, List<Integer>> map;
	private Random random;
	public Problem398(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
        	List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
        	list.add(i);
        	map.put(nums[i], list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
