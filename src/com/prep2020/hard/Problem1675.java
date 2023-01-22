package com.prep2020.hard;
import java.util.*;
public class Problem1675 {
	public int minimumDeviation(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
        	while(num % 2 == 0) num /= 2;
        	max = Math.max(max, num);
        	set.add(num);
        }
        int result = 0;
        for (int i : set) {
        	while(i % 2 != 0 && i * 2 <= max) i *= 2;
        	result = Math.max(result, max - i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1675 problem = new Problem1675();
		System.out.println(problem.minimumDeviation(new int[] {4, 1, 5, 20, 3}));
	}
}
