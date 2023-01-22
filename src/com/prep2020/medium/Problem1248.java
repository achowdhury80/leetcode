package com.prep2020.medium;
import java.util.*;
public class Problem1248 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int numberOfSubarrays(int[] nums, int k) {
        int result = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
        	if (num % 2 == 1) count++;
        	result += map.getOrDefault(count - k, 0);
        	map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1248 problem = new Problem1248();
		System.out.println(problem.numberOfSubarrays(new int[] {1,1,2,1,1},3));
	}
}
