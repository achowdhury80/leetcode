package com.prep2020.medium;
import java.util.*;
public class Problem1865 {
	private Map<Integer, Integer> map;
	private int[] n1, n2;
	public Problem1865(int[] nums1, int[] nums2) {
        this.n1 = nums1; 
        this.n2 = nums2;
        map = new HashMap<>();
        for (int i : nums2) map.put(i, map.getOrDefault(i, 0) + 1);
    }
    
    public void add(int index, int val) {
        int oldVal = n2[index];
        n2[index] += val;
        map.put(oldVal, map.get(oldVal) - 1);
        if (map.get(oldVal) == 0) map.remove(oldVal);
        map.put(n2[index], map.getOrDefault(n2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int result = 0;
        for (int i : n1) {
        	if (i >= tot) continue;
        	result += map.getOrDefault(tot - i, 0);
        }
        return result;
    }
}
