package com.prep2020.medium;
import java.util.*;
public class Problem945 {
	public int minIncrementForUnique(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        	max = Math.max(max, num);
        	min = Math.min(min, num);
        }
        int result = 0;
        int nextUnused = -1;
        for (int i = min; i <= max; i++) {
        	if (!map.containsKey(i) || map.get(i) == 1) continue;
        	while(map.get(i) > 1) {
        		while(nextUnused <= i || map.containsKey(nextUnused)) 
        			nextUnused++;
        		result += (nextUnused - i);
        		map.put(nextUnused, 1);
        		map.put(i, map.get(i) - 1);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem945 problem = new Problem945();
		System.out.println(problem.minIncrementForUnique(new int[] {1, 2, 2}));
		System.out.println(problem.minIncrementForUnique(new int[] {2, 2, 2, 1}));
	}
}
