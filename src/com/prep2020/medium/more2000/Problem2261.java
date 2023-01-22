package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2261 {
	public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
        	String hash = "";
        	int pDivisible = 0;
        	for (int j = i; j < n; j++) {
        		hash += nums[j] + ",";
        		if (nums[j] % p == 0) pDivisible++;
        		if (pDivisible > k) break;
        		set.add(hash);
        	}
        }
        return set.size();
    }
}
