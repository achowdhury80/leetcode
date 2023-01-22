package com.prep2020.medium;
import java.util.*;
public class Problem421 {
	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
        for (int i = 30; i > -1; i--) {
        	mask |= (1 << i);
        	Set<Integer> set = new HashSet<>();
        	for (int num : nums) set.add(num & mask);
        	int temp = max ^ (1 << i);
        	for (int j : set) {
        		if (set.contains(temp ^j)) {
        			max = temp;
        			break;
        		}
        	}
        }
        return max;
    }
}
