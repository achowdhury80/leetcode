package com.prep2020.medium;
import java.util.*;
public class Problem1980 {
	/**
	 * O(N)time and space
	 * @param nums
	 * @return
	 */
	public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int cur = 2;
        while(cur <= n) cur <<= 1;
        Set<String> set = new HashSet<>();
        for (String num : nums) set.add(num);
        String s = "";
        for (int i = 0; i < n; i++) s += "0";
        for (int i = 0; i < cur; i++) {
        	String temp = s + Integer.toBinaryString(i);
        	temp = temp.substring(temp.length() - n);
        	if (!set.contains(temp)) return temp;
        }
        return null;
    }
}
